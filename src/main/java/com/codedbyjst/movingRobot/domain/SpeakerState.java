package com.codedbyjst.movingRobot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SpeakerState {

    @Id
    @Column(nullable = false)
    private Long userId;

    private String speakerState;
}
