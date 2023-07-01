package com.codedbyjst.movingRobot.repository;

import com.codedbyjst.movingRobot.domain.RoomData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomDataRepository extends JpaRepository<RoomData, Long> {
    List<RoomData> findAllByUserId(Long userId);
}
