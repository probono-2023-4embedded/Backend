package com.codedbyjst.movingRobot.controller;

import com.codedbyjst.movingRobot.domain.SpeakerState;
import com.codedbyjst.movingRobot.dto.SpeakerStateCreateDto;
import com.codedbyjst.movingRobot.dto.SpeakerStateUpdateDto;
import com.codedbyjst.movingRobot.service.SpeakerStateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "speakerState", description = "스피커 상태 관련 API")
@RestController
@RequiredArgsConstructor
public class SpeakerStateController {

    private final SpeakerStateService speakerStateService;

    @GetMapping("/speakerState")
    @Operation(summary = "모든 스피커 상태 데이터 조회", description = "모든 스피커 상태 데이터를 조회합니다.")
    public List<SpeakerState> findAll() {
        return speakerStateService.findAll();
    }

    @GetMapping("/speakerState/{userId}")
    @Operation(summary = "특정 userId 스피커 상태 데이터 조회", description = "특정 userId의 스피커 상태 데이터를 조회합니다.")
    public Optional<SpeakerState> findByUserId(@PathVariable Long userId) {
        return speakerStateService.findByUserId(userId);
    }

    @PostMapping("/speakerState")
    @Operation(summary = "스피커 상태 데이터 추가", description = "스피커 상태 데이터를 추가합니다.")
    public SpeakerState add(@RequestBody @Valid SpeakerStateCreateDto speakerStateCreateDto) {
        return speakerStateService.add(speakerStateCreateDto);
    }

    @PutMapping("/speakerState/{userId}")
    @Operation(summary = "특정 userId 스피커 상태 데이터 갱신", description = "특정 userId의 스피커 상태 데이터를 갱신합니다.")
    public SpeakerState update(@PathVariable Long userId, @RequestBody @Valid SpeakerStateUpdateDto speakerStateUpdateDto) {
        return speakerStateService.update(userId, speakerStateUpdateDto);
    }

    @DeleteMapping("/speakerState/{userId}")
    @Operation(summary = "특정 userId 스피커 상태 데이터 삭제", description = "특정 userId의 스피커 상태 데이터를 삭제합니다.")
    public void deleteByUserId(@PathVariable Long userId) {
        speakerStateService.deleteByUserId(userId);
    }
}
