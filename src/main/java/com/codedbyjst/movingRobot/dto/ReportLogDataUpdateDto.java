package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportLogDataUpdateDto {

    private Long reportId;

    private Long roomId;

    private Double stepLength;

    private String wateryRisk;

    private Double xPos;

    private Double yPos;
}
