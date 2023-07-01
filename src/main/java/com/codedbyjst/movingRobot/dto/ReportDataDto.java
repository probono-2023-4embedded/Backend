package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ReportDataDto {

    @NotBlank
    private Long userId;

    private Timestamp startTime;

    private Timestamp endTime;
}
