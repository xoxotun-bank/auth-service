package com.example.authservice.service;

import java.util.*;

import com.example.authservice.model.UserEntity;
import com.example.authservice.model.token.AccessToken;
import com.example.authservice.model.RoleEntity;
import com.example.authservice.repository.PasswordRepository;
import com.example.authservice.repository.UserRepository;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    private final PasswordRepository passwordRepository;

    private final JwtTokenGeneratorService jwtTokenGeneratorService;

    public boolean checkUserCredentials(int userId, String password) {
        var salt = passwordRepository.getSaltByUserId(userId);
        if (salt == null) {
            return false;
        }
        var hashedPassword = BCrypt.hashpw(password, salt);
        return passwordRepository.existsByHash(userId, hashedPassword);
    }

    public UserEntity getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public String generateRefreshToken(int userId, UUID accessTokenJti) {
        var entity = jwtTokenGeneratorService
            .createRefreshTokenEntity(userId, accessTokenJti);

        var token = jwtTokenGeneratorService
            .generateRefreshToken(entity);

        return token;
    }

    public String generateAccessToken(UserEntity user, UUID jti) {
        var roles = user.getRoles().stream()
            .map(RoleEntity::getName)
            .toList();

        var token = AccessToken.builder()
            .roles(roles)
            .userId(user.getId())
            .city(user.getCity().getCity())
            .region(user.getCity().getRegion())
            .jti(jti)
            .build();

        var jwt = jwtTokenGeneratorService
            .generateAccessToken(token);

        return jwt;
    }

    public UUID generateJti() {
        return UUID.randomUUID();
    }

    @Transactional
    public void updateUser(UserEntity entity) {
        userRepository.save(entity);
    }

}
