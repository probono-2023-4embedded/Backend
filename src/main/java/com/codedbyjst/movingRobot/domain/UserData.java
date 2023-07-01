package com.codedbyjst.movingRobot.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@DynamicInsert
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String loginPw;

    private String name;

    private String email;

    private String tel;

    @ColumnDefault("'A'")
    private String ttsVoice;
}
