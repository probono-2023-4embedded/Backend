package com.codedbyjst.movingRobot.repository;

import com.codedbyjst.movingRobot.domain.ReportLogData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportLogDataRepository extends JpaRepository<ReportLogData, Long> {

    List<ReportLogData> findAllByReportId(Long reportId);

    List<ReportLogData> findAllByRoomId(Long roomId);
}
