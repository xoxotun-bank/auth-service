package com.example.authservice.repository;

import java.time.*;
import java.util.*;

import com.example.authservice.model.token.RefreshTokenEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokensRepository extends JpaRepository<RefreshTokenEntity, Integer> {

    Optional<RefreshTokenEntity> findByAccessTokenJti(UUID accessTokenJti);

    void deleteByExpiredAtLessThan(ZonedDateTime currentDate);

}
