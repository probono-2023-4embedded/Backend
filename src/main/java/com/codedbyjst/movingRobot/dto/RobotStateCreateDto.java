package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotStateCreateDto {

    @NotNull
    private Long userId;

    @NotNull
    private String robotState;
}
