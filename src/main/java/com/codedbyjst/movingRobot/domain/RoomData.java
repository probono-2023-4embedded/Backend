package com.codedbyjst.movingRobot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
public class RoomData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private Long userId;

    private String roomName;

    @Column(nullable = false)
    private Integer roomOrder;

    private Character isRestRoom; // Y : 화장실, N : 화장실 아님
}
