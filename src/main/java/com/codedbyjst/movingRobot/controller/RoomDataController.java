package com.codedbyjst.movingRobot.controller;

import com.codedbyjst.movingRobot.domain.RoomData;
import com.codedbyjst.movingRobot.dto.RoomDataDto;
import com.codedbyjst.movingRobot.service.RoomDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "roomData", description = "방 데이터 관련 API")
@RestController
@RequiredArgsConstructor
public class RoomDataController {

    private final RoomDataService roomDataService;

    @GetMapping("/roomData")
    @Operation(summary = "모든 방 데이터 조회", description = "모든 방 데이터를 조회합니다.")
    public List<RoomData> findAll() {
        return roomDataService.findAll();
    }

    @GetMapping("/roomData/{roomId}")
    @Operation(summary = "특정 roomId 방 데이터 조회", description = "특정 roomId의 방 데이터를 조회합니다.")
    public Optional<RoomData> findByRoomId(@PathVariable Long roomId) {
        return roomDataService.findByRoomId(roomId);
    }

    @GetMapping("/roomData/{userId}")
    @Operation(summary = "특정 userId 방 데이터 조회", description = "특정 userId의 모든 방 데이터를 조회합니다.")
    public List<RoomData> findAllByUserId(@PathVariable Long userId) {
        return roomDataService.findAllByUserId(userId);
    }

    @PostMapping("/roomData")
    @Operation(summary = "방 데이터 추가", description = "방 데이터를 추가합니다.")
    public RoomData add(@RequestBody @Valid RoomDataDto roomDataDto) {
        return roomDataService.add(roomDataDto);
    }

    @PutMapping("/roomData/{roomId}")
    @Operation(summary = "특정 roomId 방 데이터 갱신", description = "특정 roomId의 방 데이터를 갱신합니다.")
    public RoomData update(@PathVariable Long roomId, @RequestBody @Valid RoomDataDto roomDataDto) {
        return roomDataService.update(roomId, roomDataDto);
    }

    @DeleteMapping("/roomData/{roomId}")
    @Operation(summary = "특정 roomId 방 데이터 삭제", description = "특정 roomId의 방 데이터를 삭제합니다.")
    public void deleteByRoomId(@PathVariable Long roomId) {
        roomDataService.deleteByRoomId(roomId);
    }

    @DeleteMapping("/roomData/{userId}")
    @Operation(summary = "특정 userId 방 데이터 삭제", description = "특정 userId의 모든 방 데이터를 삭제합니다.")
    public void deleteAllByUserId(@PathVariable Long userId) {
        roomDataService.deleteAllByUserId(userId);
    }
}
