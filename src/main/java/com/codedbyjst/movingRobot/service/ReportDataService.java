package com.codedbyjst.movingRobot.service;

import com.codedbyjst.movingRobot.domain.ReportData;
import com.codedbyjst.movingRobot.dto.ReportDataDto;
import com.codedbyjst.movingRobot.repository.ReportDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportDataService {

    private final ReportDataRepository reportDataRepository;

    /**
     * 모든 레포트 데이터 조회
     * @return 모든 레포트 데이터 List
     */
    public List<ReportData> findAll() {
        return reportDataRepository.findAll();
    }

    /**
     * 특정 reportId의 레포트 데이터 조회
     * @param reportId 레포트 ID
     * @return 해당 레포트 ID의 ReportData
     */
    public Optional<ReportData> findByReportId(Long reportId) {
        return reportDataRepository.findById(reportId);
    }

    /**
     * 특정 유저의 레포트 데이터들 조회
     * @param userId 유저 ID
     * @return 특정 유저의 레포트 데이터 List
     */
    public List<ReportData> findAllByUserId(Long userId) {
        return reportDataRepository.findAllByUserId(userId);
    }

    /**
     * 레포트 데이터 추가
     * @param reportDataDto 추가할 ReportData 내용
     * @return 추가된 ReportData
     */
    public ReportData add(ReportDataDto reportDataDto) {
        ReportData reportData = new ReportData();

        reportData.setUserId(reportDataDto.getUserId());
        reportData.setStartTime(reportDataDto.getStartTime());
        reportData.setEndTime(reportDataDto.getEndTime());

        reportDataRepository.save(reportData);

        return reportData;
    }

    /**
     * 레포트 데이터 갱신
     * @param reportId 레포트 ID
     * @param reportDataDto 갱신할 ReportData 내용
     * @return 수정된 ReportData
     */
    public ReportData update(Long reportId, ReportDataDto reportDataDto) {
        // 레포트 데이터 검색
        ReportData reportData = reportDataRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레포트 데이터입니다."));

        // null이 아니면 갱신
        if(reportDataDto.getUserId() != null) {
            reportData.setUserId(reportDataDto.getUserId());
        }
        if(reportDataDto.getStartTime() != null) {
            reportData.setStartTime(reportDataDto.getStartTime());
        }
        if(reportDataDto.getEndTime() != null) {
            reportData.setEndTime(reportDataDto.getEndTime());
        }

        return reportData;
    }

    /**
     * 특정 reportId의 레포트 데이터 제거
     * @param reportId 레포트 ID
     */
    public void deleteByReportId(Long reportId) {
        // 레포트 데이터 검색
        ReportData reportData = reportDataRepository.findById(reportId)
                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레포트입니다."));

        // 레포트 데이터 제거
        reportDataRepository.delete(reportData);
    }

    /**
     * 특정 userId의 레포트 데이터 전체 제거
     * @param userId 유저 ID
     */
    public void deleteAllByUserId(Long userId) {
        // 레포트 데이터 검색
        List<ReportData> reportDataList = reportDataRepository.findAllByUserId(userId);

        // 레포트 데이터 전체 제거
        reportDataRepository.deleteAll(reportDataList);
    }

    /**
     * 특정 userId의 가장 최근 레포트 데이터 반환
     * @param userId 유저 ID
     * @return 가장 최근 reportData
     */
    public ReportData findMostRecentByUserId(Long userId) {
        return reportDataRepository.findFirstByUserIdAndEndTimeIsNotNullOrderByEndTimeDesc(userId);
    }
}
