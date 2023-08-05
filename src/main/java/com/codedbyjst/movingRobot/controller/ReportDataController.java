package com.codedbyjst.movingRobot.controller;

import com.codedbyjst.movingRobot.domain.ReportData;
import com.codedbyjst.movingRobot.dto.ReportDataDto;
import com.codedbyjst.movingRobot.service.ReportDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "reportData", description = "레포트 데이터 관련 API")
@RestController
@RequiredArgsConstructor
public class ReportDataController {

    private final ReportDataService reportDataService;

    @GetMapping("/reportData")
    @Operation(summary = "모든 레포트 데이터 조회", description = "모든 레포트 데이터를 조회합니다.")
    public List<ReportData> findAll() {
        return reportDataService.findAll();
    }

    @GetMapping("/reportData/{reportId}")
    @Operation(summary = "특정 reportId 레포트 데이터 조회", description = "특정 reportId의 레포트 데이터를 조회합니다.")
    public Optional<ReportData> findByReportId(@PathVariable Long reportId) {
        return reportDataService.findByReportId(reportId);
    }

    @GetMapping("/reportData/userId/{userId}")
    @Operation(summary = "특정 userId 레포트 데이터 조회", description = "특정 userId의 모든 레포트 데이터를 조회합니다.")
    public List<ReportData> findAllByUserId(@PathVariable Long userId) {
        return reportDataService.findAllByUserId(userId);
    }

    @PostMapping("/reportData")
    @Operation(summary = "레포트 데이터 추가", description = "레포트 데이터를 추가합니다.")
    public ReportData add(@RequestBody @Valid ReportDataDto reportDataDto) {
        return reportDataService.add(reportDataDto);
    }

    @PutMapping("/reportData/{reportId}")
    @Operation(summary = "특정 reportId 레포트 데이터 갱신", description = "특정 reportId의 레포트 데이터를 갱신합니다.")
    public ReportData update(@PathVariable Long reportId, @RequestBody ReportDataDto reportDataDto) {
        return reportDataService.update(reportId, reportDataDto);
    }

    @DeleteMapping("/reportData/{reportId}")
    @Operation(summary = "특정 reportId 레포트 데이터 삭제", description = "특정 reportId의 레포트 데이터를 삭제합니다.")
    public void deleteByReportId(@PathVariable Long reportId) {
        reportDataService.deleteByReportId(reportId);
    }

    @DeleteMapping("/reportData/userId/{userId}")
    @Operation(summary = "특정 userId 레포트 데이터 삭제", description = "특정 userId의 모든 레포트 데이터를 삭제합니다.")
    public void deleteAllByUserId(@PathVariable Long userId) {
        reportDataService.deleteAllByUserId(userId);
    }
}
