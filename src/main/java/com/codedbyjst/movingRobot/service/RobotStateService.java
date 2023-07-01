package com.codedbyjst.movingRobot.service;

import com.codedbyjst.movingRobot.domain.RobotState;
import com.codedbyjst.movingRobot.dto.RobotStateCreateDto;
import com.codedbyjst.movingRobot.dto.RobotStateUpdateDto;
import com.codedbyjst.movingRobot.repository.RobotStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RobotStateService {

    private final RobotStateRepository robotStateRepository;

    /**
     * 모든 로봇 데이터 조회
     * @return List<RobotState>
     */
    public List<RobotState> findAll() {
        return robotStateRepository.findAll();
    }

    /**
     * 특정 사용자의 로봇 데이터 조회
     * @param userId 유저 ID
     * @return 해당 유저의 RobotState
     */
    public Optional<RobotState> findByUserId(Long userId) {
        return robotStateRepository.findById(userId);
    }

    /**
     * 로봇 데이터 추가
     * @param robotStateCreateDto 추가될 robotState 내용
     * @return 추가된 RobotState
     */
    public RobotState add(RobotStateCreateDto robotStateCreateDto) {
        validateDuplicate(robotStateCreateDto.getUserId());

        RobotState robotState = new RobotState();
        robotState.setUserId(robotStateCreateDto.getUserId());
        robotState.setRobotState(robotStateCreateDto.getRobotState());
        robotStateRepository.save(robotState);

        return robotState;
    }
    // 중복 RobotState 검증
    public void validateDuplicate(Long userId) {
        robotStateRepository.findByUserId(userId)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 해당 userId의 RobotState가 존재합니다.");
                });
    }

    /**
     * RobotState 갱신
     * @param userId 유저 ID
     * @param robotStateUpdateDto 수정될 robotState 내용
     * @return 수정된 robotState
     */
    public RobotState update(Long userId, RobotStateUpdateDto robotStateUpdateDto) {
        // RobotState 검색
        RobotState robotState = robotStateRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalStateException("해당 유저 ID에 대한 정보가 없습니다."));

        // robotState 갱신
        robotState.setRobotState(robotStateUpdateDto.getRobotState());

        return robotState;
    }

    /**
     * 유저 제거
     * @param userId 유저 ID
     */
    public void deleteByUserId(Long userId) {
        // robotState 검색
        RobotState robotState = robotStateRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalStateException("해당 유저 ID에 대한 정보가 없습니다."));

        // robotState 제거
        robotStateRepository.delete(robotState);
    }
}
