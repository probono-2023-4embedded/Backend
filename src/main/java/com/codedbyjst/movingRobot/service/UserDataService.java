package com.codedbyjst.movingRobot.service;

import com.codedbyjst.movingRobot.domain.UserData;
import com.codedbyjst.movingRobot.dto.UserDataCreateDto;
import com.codedbyjst.movingRobot.dto.UserDataUpdateDto;
import com.codedbyjst.movingRobot.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDataService {

    private final UserDataRepository userDataRepository;

    /**
     * 모든 사용자 조회
     * @return 모든 사용자 데이터
     */
    public List<UserData> findAll() {
        return userDataRepository.findAll();
    }

    /**
     * 일부 사용자 조회
     * @param userId 유저 ID
     * @return 조회된 사용자 데이터
     */
    public Optional<UserData> findByUserId(Long userId) {
        return userDataRepository.findById(userId);
    }

    /**
     * 회원가입
     * @param userDataCreateDto 회원가입 DTO
     * @return 등록된 UserData
     */
    public UserData add(UserDataCreateDto userDataCreateDto) {
        validateDuplicate(userDataCreateDto);

        UserData userData = new UserData();
        userData.setLoginId(userDataCreateDto.getLoginId());
        userData.setLoginPw(userDataCreateDto.getLoginPw());
        userData.setName(userDataCreateDto.getName());
        userData.setEmail(userDataCreateDto.getEmail());
        userData.setTel(userDataCreateDto.getTel());
        userData.setTtsVoice(userDataCreateDto.getTtsVoice());

        userDataRepository.save(userData);

        return userData;
    }
    // 중복 회원 검증
    public void validateDuplicate(UserDataCreateDto userDataCreateDto) {
        userDataRepository.findByLoginId(userDataCreateDto.getLoginId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 유저입니다.");
                });
    }

    /**
     * 유저 정보 갱신
     * @param userId 유저 ID
     * @param userDataUpdateDto 유저 정보 갱신 DTO
     * @return 수정된 UserData
     */
    public UserData update(Long userId, UserDataUpdateDto userDataUpdateDto) {
        // 유저 검색
        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 유저입니다."));

        // null이 아니면 갱신
        if(userDataUpdateDto.getLoginId() != null) {
            userData.setLoginId(userDataUpdateDto.getLoginId());
        }
        if(userDataUpdateDto.getLoginPw() != null) {
            userData.setLoginPw(userDataUpdateDto.getLoginPw());
        }
        if(userDataUpdateDto.getName() != null) {
            userData.setName(userDataUpdateDto.getName());
        }
        if(userDataUpdateDto.getEmail() != null) {
            userData.setEmail(userDataUpdateDto.getEmail());
        }
        if(userDataUpdateDto.getTel() != null) {
            userData.setTel(userDataUpdateDto.getTel());
        }
        if(userDataUpdateDto.getTtsVoice() != null) {
            userData.setTtsVoice(userDataUpdateDto.getTtsVoice());
        }

        return userData;
    }

    /**
     * 유저 제거
     * @param userId 유저 ID
     */
    public void deleteByUserId(Long userId) {
        // 유저 검색
        UserData userData = userDataRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        // 유저 제거
        userDataRepository.delete(userData);
    }

}
