package com.codedbyjst.movingRobot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecentReportLogDataDto {
    private Long roomId;
    private Long reportId;
    private Double stepLength;
    private String wateryRisk;
    private Double xPos;
    private Double yPos;
}
