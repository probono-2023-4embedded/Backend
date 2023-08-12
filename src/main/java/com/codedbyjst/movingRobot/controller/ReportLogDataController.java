package com.codedbyjst.movingRobot.controller;

import com.codedbyjst.movingRobot.domain.ReportData;
import com.codedbyjst.movingRobot.domain.ReportLogData;
import com.codedbyjst.movingRobot.dto.ReportLogDataRecentDto;
import com.codedbyjst.movingRobot.dto.ReportLogDataCreateDto;
import com.codedbyjst.movingRobot.dto.ReportLogDataUpdateDto;
import com.codedbyjst.movingRobot.service.ReportDataService;
import com.codedbyjst.movingRobot.service.ReportLogDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Tag(name = "reportLogData", description = "레포트 로그 데이터 관련 API")
@RestController
@RequiredArgsConstructor
public class ReportLogDataController {

    private final ReportDataService reportDataService;
    private final ReportLogDataService reportLogDataService;

    @GetMapping("/reportLogData")
    @Operation(summary = "모든 레포트 로그 데이터 조회", description = "모든 레포트 로그 데이터를 조회합니다.")
    public List<ReportLogData> findAll() {
        return reportLogDataService.findAll();
    }

    @GetMapping("/reportLogData/{reportLogId}")
    @Operation(summary = "특정 reportLogId 레포트 로그 데이터 조회", description = "특정 reportLogId의 레포트 로그 데이터를 조회합니다.")
    public Optional<ReportLogData> findByReportLogId(@PathVariable Long reportLogId) {
        return reportLogDataService.findByReportLogId(reportLogId);
    }

    @GetMapping("/reportLogData/reportId/{reportId}")
    @Operation(summary = "특정 reportId 레포트 로그 데이터 조회", description = "특정 reportId의 모든 레포트 로그 데이터를 조회합니다.")
    public List<ReportLogData> findAllByReportId(@PathVariable Long reportId) {
        return reportLogDataService.findAllByReportId(reportId);
    }

    @GetMapping("/reportLogData/roomId/{roomId}")
    @Operation(summary = "특정 roomId 레포트 로그 데이터 조회", description = "특정 roomId의 모든 레포트 로그 데이터를 조회합니다.")
    public List<ReportLogData> findAllByRoomId(@PathVariable Long roomId) {
        return reportLogDataService.findAllByRoomId(roomId);
    }

    @PostMapping("/reportLogData")
    @Operation(summary = "레포트 로그 데이터 추가", description = "레포트 로그 데이터를 추가합니다.")
    public ReportLogData add(@RequestBody @Valid ReportLogDataCreateDto reportLogDataCreateDto) {
        return reportLogDataService.add(reportLogDataCreateDto);
    }

    @PutMapping("/reportLogData/{reportLogId}")
    @Operation(summary = "특정 reportLogId 레포트 로그 데이터 갱신", description = "특정 reportLogId의 레포트 로그 데이터를 갱신합니다.")
    public ReportLogData update(@PathVariable Long reportLogId, @RequestBody @Valid ReportLogDataUpdateDto reportLogDataUpdateDto) {
        return reportLogDataService.update(reportLogId, reportLogDataUpdateDto);
    }

    @DeleteMapping("/reportLogData/{reportLogId}")
    @Operation(summary = "특정 reportLogId 레포트 로그 데이터 삭제", description = "특정 reportLogId의 레포트 로그 데이터를 삭제합니다.")
    public void deleteByReportLogId(@PathVariable Long reportLogId) {
        reportLogDataService.deleteByReportLogId(reportLogId);
    }

    @DeleteMapping("/reportLogData/reportId/{reportId}")
    @Operation(summary = "특정 reportId 레포트 로그 데이터 삭제", description = "특정 reportId의 모든 레포트 로그 데이터를 삭제합니다.")
    public void deleteAllByReportId(@PathVariable Long reportId) {
        reportLogDataService.deleteAllByReportId(reportId);
    }

    @DeleteMapping("/reportLogData/roomId/{roomId}")
    @Operation(summary = "특정 roomId 레포트 로그 데이터 삭제", description = "특정 roomId의 모든 레포트 로그 데이터를 삭제합니다.")
    public void deleteAllByRoomId(@PathVariable Long roomId) {
        reportLogDataService.deleteAllByRoomId(roomId);
    }

    @GetMapping("/reportLogData/recent/{userId}/{roomId}")
    @Operation(summary = "특정 userId, roomId 조합의 가장 최근 데이터를 가져옵니다.")
    public ReportLogDataRecentDto getRecentData(@PathVariable Long userId, Long roomId) {
        // 가장 최근 레포트를 구합니다.
        ReportData reportData = reportDataService.findMostRecentByUserId(userId);
        Long reportId = reportData.getReportId();

        // 해당 레포트의 reportLog들을 구합니다.
        ReportLogDataRecentDto reportLogDataRecentDto = new ReportLogDataRecentDto();
        reportLogDataRecentDto.setRoomId(roomId);
        reportLogDataRecentDto.setReportId(reportId);
        List<ReportLogData> reportLogDataList = reportLogDataService.findAllByReportId(reportId);
        for(ReportLogData reportLogData: reportLogDataList) {
            if(Objects.equals(reportLogData.getRoomId(), roomId)) {
                if(reportLogData.getStepLength() != null) {
                    reportLogDataRecentDto.setStepLength(reportLogData.getStepLength());
                }
                if(reportLogData.getWateryRisk() != null) {
                    reportLogDataRecentDto.setWateryRisk(reportLogData.getWateryRisk());
                }
                if(reportLogData.getXPos() != null) {
                    reportLogDataRecentDto.setXPos(reportLogData.getXPos());
                }
                if(reportLogData.getYPos() != null) {
                    reportLogDataRecentDto.setYPos(reportLogData.getYPos());
                }
                if(reportLogData.getDiffXPos() != null) {
                    reportLogDataRecentDto.setDiffXPos(reportLogData.getDiffXPos());
                }
                if(reportLogData.getDiffYPos() != null) {
                    reportLogDataRecentDto.setDiffYPos(reportLogData.getDiffYPos());
                }
            }
        }

        return reportLogDataRecentDto;
    }
}
