package com.codedbyjst.movingRobot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ReportLogData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long reportLogId;

    @Column(nullable = false)
    private Long reportId;

    @Column(nullable = false)
    private Long roomId;

    private Double stepLength;

    private String wateryRisk;

    private Double xPos;

    private Double yPos;
}
