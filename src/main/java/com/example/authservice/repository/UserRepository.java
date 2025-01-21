package com.example.authservice.repository;

import com.example.authservice.model.UserEntity;
import org.springframework.data.jpa.repository.*;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);

}
