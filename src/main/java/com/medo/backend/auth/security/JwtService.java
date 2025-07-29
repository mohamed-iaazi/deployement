package com.medo.backend.auth.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private SecretKey key;

    private JwtParser jwtParser;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
        this.jwtParser = Jwts.parser().verifyWith(key).build();
    }

    public String generateJwtToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(now))
                .expiration(new Date(now + jwtExpiration))
                .signWith(key)
                .compact();
    }

    private Claims parseClaims(String token) {
        return jwtParser.parseSignedClaims(token).getPayload();
    }

    public String getUsernameFromToken(String token) {
        return parseClaims(token).getSubject();
    }

    public boolean validateJwtToken(String token, UserDetails userDetails) {
        try {
            return userDetails.getUsername().equals(getUsernameFromToken(token)) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTokenExpired(String token) {
        try {
            return parseClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            logger.error("JWT token is expired or invalid: {}", e.getMessage());
            return true;
        }
    }
}
