package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDataDto {

    @NotNull
    private Long userId;

    private String roomName;

    private Integer roomOrder;

    private Character isRestRoom;
}
