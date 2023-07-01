package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportLogDataCreateDto {

    @NotBlank
    private Long reportId;

    @NotBlank
    private Long roomId;

    private Double stepLength;

    private Integer wateryPixelCnt;

    private String objectInfo;
}
