# Docker Configuration for Spring Boot Backend

This project includes Docker configurations for both development and production environments.

## Files Overview

- `Dockerfile` - Development Dockerfile with basic configuration
- `Dockerfile.prod` - Production Dockerfile with optimized JVM settings
- `docker-compose.yml` - Complete development environment with MySQL database
- `.dockerignore` - Excludes unnecessary files from Docker build context

## Quick Start (Development)

### Option 1: Using Docker Compose (Recommended for Development)

This will start both the Spring Boot application and MySQL database:

```bash
# Build and start all services
docker-compose up --build

# Run in background
docker-compose up -d --build

# View logs
docker-compose logs -f backend

# Stop all services
docker-compose down
```

### Option 2: Using Dockerfile Only

If you have an external MySQL database:

```bash
# Build the image
docker build -t backend-app .

# Run the container
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://your-mysql-host:3306/Question \
  -e SPRING_DATASOURCE_USERNAME=your-username \
  -e SPRING_DATASOURCE_PASSWORD=your-password \
  backend-app
```

## Production Deployment

### Using Production Dockerfile

```bash
# Build production image
docker build -f Dockerfile.prod -t backend-app:prod .

# Run production container
docker run -d \
  --name backend-prod \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://your-prod-mysql:3306/Question \
  -e SPRING_DATASOURCE_USERNAME=prod-user \
  -e SPRING_DATASOURCE_PASSWORD=prod-password \
  backend-app:prod
```

## Environment Variables

The following environment variables can be configured:

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_DATASOURCE_URL` | MySQL connection URL | `jdbc:mysql://mysql:3306/Question` |
| `SPRING_DATASOURCE_USERNAME` | Database username | `root` |
| `SPRING_DATASOURCE_PASSWORD` | Database password | `root` |
| `SPRING_JPA_HIBERNATE_DDL_AUTO` | Hibernate DDL mode | `update` |
| `SPRING_JPA_OPEN_IN_VIEW` | Open Session in View | `true` |

## Health Checks

Both Dockerfiles include health checks that monitor the application status:

- **Interval**: 30 seconds
- **Timeout**: 3 seconds
- **Retries**: 3 attempts
- **Start Period**: 60 seconds (initial startup grace period)

## Security Features

- Runs as non-root user (`appuser`)
- Uses Alpine Linux for smaller attack surface
- Multi-stage build to reduce final image size
- Excludes sensitive files via `.dockerignore`

## Ports

- **8080**: Spring Boot application
- **3306**: MySQL database (when using docker-compose)

## Volumes

When using docker-compose, MySQL data is persisted in a named volume:
- `mysql_data`: MySQL database files

## Troubleshooting

### Common Issues

1. **Port already in use**: Change the port mapping in docker-compose.yml
2. **Database connection issues**: Ensure MySQL is running and credentials are correct
3. **Build failures**: Check that all dependencies are properly defined in pom.xml

### Useful Commands

```bash
# Check container status
docker ps

# View container logs
docker logs backend-app

# Access container shell
docker exec -it backend-app sh

# Check health status
docker inspect backend-app | grep Health -A 10

# Clean up unused resources
docker system prune -a
```

## Performance Optimization

The production Dockerfile includes optimized JVM settings:
- G1 Garbage Collector
- Container-aware memory settings
- Optimized startup with `/dev/urandom`

## Network Configuration

Docker Compose creates a custom network `backend-network` for secure communication between services. 