package com.codedbyjst.movingRobot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ReservationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String reservationTime; // ex. "09:00"
}
