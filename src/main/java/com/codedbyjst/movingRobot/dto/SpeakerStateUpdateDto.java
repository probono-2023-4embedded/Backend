package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeakerStateUpdateDto {

    @NotNull
    private String speakerState;
}
