package com.codedbyjst.movingRobot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RobotState {

    @Id
    @Column(nullable = false)
    private Long userId;

    private String robotState;
}
