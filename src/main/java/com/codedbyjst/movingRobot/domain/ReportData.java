package com.codedbyjst.movingRobot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ReportData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @NotBlank
    private Long userId;

    @CreationTimestamp
    private Timestamp startTime;

    private Timestamp endTime;
}
