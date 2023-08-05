package com.codedbyjst.movingRobot.repository;

import com.codedbyjst.movingRobot.domain.ReportData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportDataRepository extends JpaRepository<ReportData, Long> {
    List<ReportData> findAllByUserId(Long userId);
    ReportData findFirstByUserIdAndEndTimeIsNotNullOrderByEndTimeDesc(Long userId);
}
