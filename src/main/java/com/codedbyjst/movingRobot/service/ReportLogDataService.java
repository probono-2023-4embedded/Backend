package com.codedbyjst.movingRobot.service;

import com.codedbyjst.movingRobot.domain.ReportLogData;
import com.codedbyjst.movingRobot.dto.ReportLogDataCreateDto;
import com.codedbyjst.movingRobot.dto.ReportLogDataUpdateDto;
import com.codedbyjst.movingRobot.repository.ReportLogDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportLogDataService {

    private final ReportLogDataRepository reportLogDataRepository;

    /**
     * 모든 레포트 로그 데이터 조회
     * @return 모든 레포트 로그 데이터 List
     */
    public List<ReportLogData> findAll() {
        return reportLogDataRepository.findAll();
    }

    /**
     * 특정 reportLogId의 레포트 로그 데이터 조회
     * @param reportLogId 리포트 로그 ID
     * @return 해당 reportLogId의 레포트 로그 데이터
     */
    public Optional<ReportLogData> findByReportLogId(Long reportLogId) {
        return reportLogDataRepository.findById(reportLogId);
    }

    /**
     * 특정 reportId의 레포트 로그 데이터 조회
     * @param reportId 레포트 ID
     * @return 해당 reportId의 모든 레포트 로그 데이터 List
     */
    public List<ReportLogData> findAllByReportId(Long reportId) {
        return reportLogDataRepository.findAllByReportId(reportId);
    }

    /**
     * 특정 roomId의 레포트 로그 데이터 조회
     * @param roomId 방 ID
     * @return 해당 roomId의 모든 레포트 로그 데이터 List
     */
    public List<ReportLogData> findAllByRoomId(Long roomId) {
        return reportLogDataRepository.findAllByRoomId(roomId);
    }

    /**
     * 레포트 로그 데이터 추가
     * @param reportLogDataCreateDto 추가할 ReportLogData 내용
     * @return 추가된 ReportLogData
     */
    public ReportLogData add(ReportLogDataCreateDto reportLogDataCreateDto) {
        ReportLogData reportLogData = new ReportLogData();

        reportLogData.setReportId(reportLogDataCreateDto.getReportId());
        reportLogData.setRoomId(reportLogDataCreateDto.getRoomId());
        reportLogData.setStepLength(reportLogDataCreateDto.getStepLength());
        reportLogData.setWateryRisk(reportLogDataCreateDto.getWateryRisk());
        reportLogData.setXPos(reportLogDataCreateDto.getXPos());
        reportLogData.setYPos(reportLogDataCreateDto.getYPos());

        reportLogDataRepository.save(reportLogData);

        return reportLogData;
    }

    /**
     * 레포트 로그 데이터 갱신
     * @param reportLogId 레포트 로그 ID
     * @param reportLogDataUpdateDto 수정할 ReportLogData 내용
     * @return 수정된 ReportLogData
     */
    public ReportLogData update(Long reportLogId, ReportLogDataUpdateDto reportLogDataUpdateDto) {
        // 레포트 로그 데이터 검색
        ReportLogData reportLogData = reportLogDataRepository.findById(reportLogId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 레포트 로그 데이터입니다."));

        // null이 아니면 갱신
        if(reportLogDataUpdateDto.getReportId() != null) {
            reportLogData.setReportId(reportLogDataUpdateDto.getReportId());
        }
        if(reportLogDataUpdateDto.getRoomId() != null) {
            reportLogData.setRoomId(reportLogDataUpdateDto.getRoomId());
        }
        if(reportLogDataUpdateDto.getStepLength() != null) {
            reportLogData.setStepLength(reportLogDataUpdateDto.getStepLength());
        }
        if(reportLogDataUpdateDto.getWateryRisk() != null) {
            reportLogData.setWateryRisk(reportLogDataUpdateDto.getWateryRisk());
        }
        if(reportLogDataUpdateDto.getXPos() != null) {
            reportLogData.setXPos(reportLogDataUpdateDto.getXPos());
        }
        if(reportLogDataUpdateDto.getYPos() != null) {
            reportLogData.setYPos(reportLogDataUpdateDto.getYPos());
        }

        return reportLogData;
    }

    /**
     * 특정 reportLogId의 레포트 로그 데이터 제거
     * @param reportLogId 레포트 로그 ID
     */
    public void deleteByReportLogId(Long reportLogId) {
        reportLogDataRepository.deleteById(reportLogId);
    }

    /**
     * 특정 reportId의 레포트 로그 데이터 전체 제거
     * @param reportId 레포트 ID
     */
    public void deleteAllByReportId(Long reportId) {
        // 레포트 로그 데이터 검색
        List<ReportLogData> reportLogDataList = reportLogDataRepository.findAllByReportId(reportId);

        // 레포트 로그 데이터 제거
        reportLogDataRepository.deleteAll(reportLogDataList);
    }

    /**
     * 특정 roomId의 레포트 로그 데이터 전체 제거
     * @param roomId 방 ID
     */
    public void deleteAllByRoomId(Long roomId) {
        // 레포트 로그 데이터 검색
        List<ReportLogData> reportLogDataList = reportLogDataRepository.findAllByRoomId(roomId);

        // 레포트 로그 데이터 제거
        reportLogDataRepository.deleteAll(reportLogDataList);
    }
}
