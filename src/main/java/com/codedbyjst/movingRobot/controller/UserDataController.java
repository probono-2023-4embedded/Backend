package com.codedbyjst.movingRobot.controller;

import com.codedbyjst.movingRobot.domain.UserData;
import com.codedbyjst.movingRobot.dto.UserDataCreateDto;
import com.codedbyjst.movingRobot.dto.UserDataUpdateDto;
import com.codedbyjst.movingRobot.service.UserDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "userData", description = "유저 정보 관련 API")
@RestController
@RequiredArgsConstructor
public class UserDataController {

    private final UserDataService userDataService;

    @GetMapping("/userData")
    @Operation(summary = "모든 유저 데이터 조회", description = "모든 유저의 데이터를 조회합니다.")
    public List<UserData> findAll() {
        return userDataService.findAll();
    }

    @GetMapping("/userData/{userId}")
    @Operation(summary = "특정 userId 유저 데이터 조회", description = "특정 userId 유저의 데이터를 조회합니다.")
    public Optional<UserData> findByUserId(@PathVariable Long userId) {
        return userDataService.findByUserId(userId);
    }

    @PostMapping("/userData")
    @Operation(summary = "유저 데이터 추가", description = "유저 데이터를 추가합니다.")
    public UserData add(@RequestBody @Valid UserDataCreateDto userDataCreateDto) {
        return userDataService.add(userDataCreateDto);
    }

    @PutMapping("/userData/{userId}")
    @Operation(summary = "특정 userId 유저 데이터 갱신", description = "특정 userId의 유저 데이터를 갱신합니다.")
    public UserData update(@PathVariable Long userId, @RequestBody @Valid UserDataUpdateDto userDataUpdateDto) {
        return userDataService.update(userId, userDataUpdateDto);
    }

    @DeleteMapping("/userData/{userId}")
    @Operation(summary = "특정 userId 유저 데이터 삭제", description = "특정 userId의 유저 데이터를 삭제합니다.")
    public void deleteByUserId(@PathVariable Long userId) {
        userDataService.deleteByUserId(userId);
    }
}
