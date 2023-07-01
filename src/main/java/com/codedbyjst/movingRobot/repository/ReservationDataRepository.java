package com.codedbyjst.movingRobot.repository;

import com.codedbyjst.movingRobot.domain.ReservationData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDataRepository extends JpaRepository<ReservationData, Long> {
    List<ReservationData> findAllByUserId(Long userId);
}
