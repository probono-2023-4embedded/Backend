package com.codedbyjst.movingRobot.repository;

import com.codedbyjst.movingRobot.domain.SpeakerState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpeakerStateRepository extends JpaRepository<SpeakerState, Long> {
    Optional<SpeakerState> findByUserId(Long userId);
}
