package com.codedbyjst.movingRobot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataCreateDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String loginPw;

    private String name;

    private String email;

    private String tel;

    private String ttsVoice;
}
