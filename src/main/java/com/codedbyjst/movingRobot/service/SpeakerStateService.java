package com.codedbyjst.movingRobot.service;

import com.codedbyjst.movingRobot.domain.SpeakerState;
import com.codedbyjst.movingRobot.dto.SpeakerStateCreateDto;
import com.codedbyjst.movingRobot.dto.SpeakerStateUpdateDto;
import com.codedbyjst.movingRobot.repository.SpeakerStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SpeakerStateService {

    private final SpeakerStateRepository speakerStateRepository;

    /**
     * 모든 speakerState 데이터 조회
     * @return List<SpeakerState>
     */
    public List<SpeakerState> findAll() {
        return speakerStateRepository.findAll();
    }

    /**
     * 특정 사용자의 로봇 데이터 조회
     * @param userId 유저 ID
     * @return 해당 유저의 SpeakerState
     */
    public Optional<SpeakerState> findByUserId(Long userId) {
        return speakerStateRepository.findById(userId);
    }

    /**
     * 로봇 데이터 추가
     * @param speakerStateCreateDto 추가될 robotState 내용
     * @return 추가된 RobotState
     */
    public SpeakerState add(SpeakerStateCreateDto speakerStateCreateDto) {
        validateDuplicate(speakerStateCreateDto.getUserId());

        SpeakerState speakerState = new SpeakerState();
        speakerState.setUserId(speakerStateCreateDto.getUserId());
        speakerState.setSpeakerState(speakerStateCreateDto.getSpeakerState());
        speakerStateRepository.save(speakerState);

        return speakerState;
    }
    // 중복 speakerState 검증
    public void validateDuplicate(Long userId) {
        speakerStateRepository.findByUserId(userId)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 해당 userId의 speakerState가 존재합니다.");
                });
    }

    /**
     * speakerState 갱신
     * @param userId 유저 ID
     * @param speakerStateUpdateDto 수정될 speakerState 내용
     * @return 수정된 speakerState
     */
    public SpeakerState update(Long userId, SpeakerStateUpdateDto speakerStateUpdateDto) {
        // speakerState 검색
        SpeakerState speakerState = speakerStateRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalStateException("해당 유저 ID에 대한 정보가 없습니다."));

        // robotState 갱신
        speakerState.setSpeakerState(speakerStateUpdateDto.getSpeakerState());

        return speakerState;
    }

    /**
     * SpeakerState 제거
     * @param userId 유저 ID
     */
    public void deleteByUserId(Long userId) {
        // robotState 검색
        SpeakerState speakerState = speakerStateRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalStateException("해당 유저 ID에 대한 정보가 없습니다."));

        // robotState 제거
        speakerStateRepository.delete(speakerState);
    }
}
