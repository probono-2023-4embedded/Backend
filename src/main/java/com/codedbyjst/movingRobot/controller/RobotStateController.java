package com.codedbyjst.movingRobot.controller;

import com.codedbyjst.movingRobot.domain.RobotState;
import com.codedbyjst.movingRobot.dto.RobotStateCreateDto;
import com.codedbyjst.movingRobot.dto.RobotStateUpdateDto;
import com.codedbyjst.movingRobot.service.RobotStateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "robotState", description = "로봇 상태 관련 API")
@RestController
@RequiredArgsConstructor
public class RobotStateController {

    private final RobotStateService robotStateService;

    @GetMapping("/robotState")
    @Operation(summary = "모든 로봇 상태 데이터 조회", description = "모든 로봇 상태 데이터를 조회합니다.")
    public List<RobotState> findAll() {
        return robotStateService.findAll();
    }

    @GetMapping("/robotState/{userId}")
    @Operation(summary = "특정 userId 로봇 상태 데이터 조회", description = "특정 userId의 로봇 상태 데이터를 조회합니다.")
    public Optional<RobotState> findByUserId(@PathVariable Long userId) {
        return robotStateService.findByUserId(userId);
    }

    @PostMapping("/robotState")
    @Operation(summary = "로봇 상태 데이터 추가", description = "로봇 상태 데이터를 추가합니다.")
    public RobotState add(@RequestBody @Valid RobotStateCreateDto robotStateCreateDto) {
        return robotStateService.add(robotStateCreateDto);
    }

    @PutMapping("/robotState/{userId}")
    @Operation(summary = "특정 userId 로봇 상태 데이터 갱신", description = "특정 userId의 로봇 상태 데이터를 갱신합니다.")
    public RobotState update(@PathVariable Long userId, @RequestBody @Valid RobotStateUpdateDto robotStateUpdateDto) {
        return robotStateService.update(userId, robotStateUpdateDto);
    }

    @DeleteMapping("/robotState/{userId}")
    @Operation(summary = "특정 userId 로봇 상태 데이터 삭제", description = "특정 userId의 로봇 상태 데이터를 삭제합니다.")
    public void deleteByUserId(@PathVariable Long userId) {
        robotStateService.deleteByUserId(userId);
    }
}
