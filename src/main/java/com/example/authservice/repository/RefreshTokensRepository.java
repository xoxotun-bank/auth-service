package com.example.authservice.repository;

import java.time.*;
import java.util.*;

import org.springframework.data.jpa.repository.*;


public interface RefreshTokensRepository extends JpaRepository<RefreshTokenEntity, Integer> {

    Optional<RefreshTokenEntity> findByAccessTokenJti(UUID accessTokenJti);

    void deleteByExpiredAtLessThan(ZonedDateTime currentDate);

}
