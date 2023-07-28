package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeakerStateCreateDto {

    @NotNull
    private Long userId;

    @NotNull
    private String speakerState;
}
