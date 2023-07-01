package com.codedbyjst.movingRobot.repository;

import com.codedbyjst.movingRobot.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    Optional<UserData> findByLoginId(String loginId);
}
