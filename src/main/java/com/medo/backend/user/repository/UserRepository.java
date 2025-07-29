package com.medo.backend.user.repository;

import com.medo.backend.user.dto.UserProfileDTO;
import com.medo.backend.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
