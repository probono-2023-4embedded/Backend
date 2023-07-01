package com.codedbyjst.movingRobot.controller;

import com.codedbyjst.movingRobot.domain.ReservationData;
import com.codedbyjst.movingRobot.dto.ReservationDataDto;
import com.codedbyjst.movingRobot.service.ReservationDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "reservationData", description = "예약 데이터 관련 API")
@RestController
@RequiredArgsConstructor
public class ReservationDataController {

    private final ReservationDataService reservationDataService;

    @GetMapping("/reservationData")
    @Operation(summary = "모든 예약 데이터 조회", description = "모든 예약 데이터를 조회합니다.")
    public List<ReservationData> findAll() {
        return reservationDataService.findAll();
    }

    @GetMapping("/reservationData/{reservationId}")
    @Operation(summary = "특정 reservationId 예약 데이터 조회", description = "특정 reservationId에 해당하는 예약 데이터를 조회합니다.")
    public Optional<ReservationData> findByReservationId(@PathVariable Long reservationId) {
        return reservationDataService.findByReservationId(reservationId);
    }

    @GetMapping("/reservationData/userId/{userId}")
    @Operation(summary = "특정 userId 예약 데이터 조회", description = "특정 userId에 해당하는 모든 예약 데이터를 조회합니다.")
    public List<ReservationData> findAllByUserId(@PathVariable Long userId) {
        return reservationDataService.findAllByUserId(userId);
    }

    @PostMapping("/reservationData")
    @Operation(summary = "예약 데이터 추가", description = "예약 데이터를 추가합니다.")
    public ReservationData add(@RequestBody @Valid ReservationDataDto reservationDataDto) {
        return reservationDataService.add(reservationDataDto);
    }

    @PutMapping("/reservationData/{reservationId}")
    @Operation(summary = "특정 reservationId 예약 데이터 갱신", description = "특정 reservationId에 해당하는 예약 데이터를 갱신합니다.")
    public ReservationData update(@PathVariable Long reservationId, @RequestBody ReservationDataDto reservationDataDto) {
        return reservationDataService.update(reservationId, reservationDataDto);
    }

    @DeleteMapping("/reservationData/{reservationId}")
    @Operation(summary = "특정 reservationId 예약 데이터 삭제", description = "특정 reservationId에 해당하는 예약 데이터를 삭제합니다.")
    public void deleteByReservationId(@PathVariable Long reservationId) {
        reservationDataService.deleteByReservationId(reservationId);
    }

    @DeleteMapping("/reservationData/userId/{userId}")
    @Operation(summary = "특정 userId 예약 데이터 삭제", description = "특정 userId에 해당하는 모든 예약 데이터를 삭제합니다.")
    public void deleteAllByUserId(@PathVariable Long userId) {
        reservationDataService.deleteAllByUserId(userId);
    }
}

