package com.example.authservice.repository;

import com.example.authservice.model.PasswordEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;


@Repository
public interface PasswordRepository extends JpaRepository<PasswordEntity, Integer> {

    @Query(
        value = "select case when (count(*)>0) then true else false end " +
                "from passwords p where p.user_id=:userId and p.hash=:hash and p.active=true",
        nativeQuery = true
    )
    Boolean existsByHash(int userId, String hash);

    @Query(
        value = "select salt from passwords p where p.user_id=:userId and p.active=true",
        nativeQuery = true
    )
    String getSaltByUserId(int userId);

}
