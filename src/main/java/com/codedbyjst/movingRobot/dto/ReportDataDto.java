package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ReportDataDto {

    @NotNull
    private Long userId;

    private Timestamp startTime;

    private Timestamp endTime;
}
