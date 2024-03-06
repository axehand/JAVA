package com.ohgiraffers.userservice.repository;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import com.ohgiraffers.userservice.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
