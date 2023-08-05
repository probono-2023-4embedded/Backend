package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportLogDataCreateDto {

    @NotNull
    private Long reportId;

    @NotNull
    private Long roomId;

    private Double stepLength;

    private String wateryRisk;

    private Double xPos;

    private Double yPos;
}
