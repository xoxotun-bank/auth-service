package com.example.authservice.scheduler;

import java.time.*;

import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import com.example.authservice.repository.*;

@Component
@RequiredArgsConstructor
public class RefreshTokenScheduler {

    private final RefreshTokensRepository refreshTokensRepository;

    @Transactional
    @Scheduled(cron = "${scheduler.refresh-token.delete-expired.cron}")
    public void schedulerDeleteExpiredTokens() {
        var currentDate = ZonedDateTime.now();
        refreshTokensRepository.deleteByExpiredAtLessThan(currentDate);
    }

}
