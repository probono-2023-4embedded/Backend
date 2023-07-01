package com.codedbyjst.movingRobot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataUpdateDto {

    private String loginId;

    private String loginPw;

    private String name;

    private String email;

    private String tel;

    private String ttsVoice;
}
