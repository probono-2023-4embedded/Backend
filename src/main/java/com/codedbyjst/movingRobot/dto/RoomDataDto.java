package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDataDto {

    @NotBlank
    private Long userId;

    private String roomName;

    private Integer roomOrder;

    private Character isRestRoom;
}
