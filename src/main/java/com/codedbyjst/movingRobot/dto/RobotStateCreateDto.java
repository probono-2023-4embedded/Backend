package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotStateCreateDto {

    @NotBlank
    private Long userId;

    @NotNull
    private String robotState;
}
