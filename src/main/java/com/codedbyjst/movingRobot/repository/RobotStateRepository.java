package com.codedbyjst.movingRobot.repository;

import com.codedbyjst.movingRobot.domain.RobotState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RobotStateRepository extends JpaRepository<RobotState, Long> {
    Optional<RobotState> findByUserId(Long userId);
}
