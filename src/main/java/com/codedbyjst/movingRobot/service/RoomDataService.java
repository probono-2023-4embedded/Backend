package com.codedbyjst.movingRobot.service;

import com.codedbyjst.movingRobot.domain.RoomData;
import com.codedbyjst.movingRobot.dto.RoomDataDto;
import com.codedbyjst.movingRobot.repository.RoomDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomDataService {

    private final RoomDataRepository roomDataRepository;

    /**
     * 모든 방 데이터 조회
     * @return 모든 방 데이터 List
     */
    public List<RoomData> findAll() {
        return roomDataRepository.findAll();
    }

    /**
     * 특정 roomId의 방 데이터 조회
     * @param roomId 방 ID
     * @return 해당 방 ID의 RoomData
     */
    public Optional<RoomData> findByRoomId(Long roomId) {
        return roomDataRepository.findById(roomId);
    }

    /**
     * 특정 유저의 방 데이터들 조회
     * @param userId 유저 ID
     * @return 특정 유저의 방 데이터 List
     */
    public List<RoomData> findAllByUserId(Long userId) {
        return roomDataRepository.findAllByUserId(userId);
    }

    /**
     * 방 데이터 추가
     * @param roomDataDto 추가할 RoomData 내용
     * @return 추가된 RoomData
     */
    public RoomData add(RoomDataDto roomDataDto) {
        RoomData roomData = new RoomData();

        roomData.setUserId(roomDataDto.getUserId());
        roomData.setRoomName(roomDataDto.getRoomName());
        roomData.setRoomOrder(roomDataDto.getRoomOrder());
        roomData.setIsRestRoom(roomDataDto.getIsRestRoom());

        roomDataRepository.save(roomData);

        return roomData;
    }

    /**
     * 방 데이터 갱신
     * @param roomId 방 ID
     * @param roomDataDto 수정할 RoomData 내용
     * @return 수정된 RoomData
     */
    public RoomData update(Long roomId, RoomDataDto roomDataDto) {
        // 방 데이터 검색
        RoomData roomData = roomDataRepository.findById(roomId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 방 데이터입니다."));

        // null이 아니면 갱신
        if(roomDataDto.getUserId() != null) {
            roomData.setUserId(roomDataDto.getUserId());
        }
        if(roomDataDto.getRoomName() != null) {
            roomData.setRoomName(roomDataDto.getRoomName());
        }
        if(roomDataDto.getRoomOrder() != null) {
            roomData.setRoomOrder(roomDataDto.getRoomOrder());
        }
        if(roomDataDto.getIsRestRoom() != null) {
            roomData.setIsRestRoom(roomDataDto.getIsRestRoom());
        }

        return roomData;
    }

    /**
     * 특정 roomId의 방 데이터 제거
     * @param roomId 방 ID
     */
    public void deleteByRoomId(Long roomId) {
        // 방 데이터 검색
        RoomData roomData = roomDataRepository.findById(roomId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 방 데이터입니다."));

        // 방 데이터 제거
        roomDataRepository.delete(roomData);
    }

    /**
     * 특정 userId의 방 데이터 전체 제거
     * @param userId 유저 ID
     */
    public void deleteAllByUserId(Long userId) {
        // 방 데이터 검색
        List<RoomData> roomDataList = roomDataRepository.findAllByUserId(userId);

        // 방 데이터 제거
        roomDataRepository.deleteAll(roomDataList);
    }
}
