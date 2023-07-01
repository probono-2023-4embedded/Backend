package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotStateUpdateDto {

    @NotNull
    private String robotState;
}
