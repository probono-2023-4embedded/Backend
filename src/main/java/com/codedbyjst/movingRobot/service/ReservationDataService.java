package com.codedbyjst.movingRobot.service;

import com.codedbyjst.movingRobot.domain.ReservationData;
import com.codedbyjst.movingRobot.dto.ReservationDataDto;
import com.codedbyjst.movingRobot.repository.ReservationDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationDataService {

    private final ReservationDataRepository reservationDataRepository;

    /**
     * 모든 예약 데이터 조회
     * @return List<ReservationData>
     */
    public List<ReservationData> findAll() {
        return reservationDataRepository.findAll();
    }

    /**
     * 특정 reservationId의 예약 데이터 조회
     * @param reservationId 예약 ID
     * @return 해당 예약 ID의 ReservationData
     */
    public Optional<ReservationData> findByReservationId(Long reservationId) {
        return reservationDataRepository.findById(reservationId);
    }

    /**
     * 특정 유저의 예약 데이터들 조회
     * @param userId 유저 ID
     * @return 특정 유저의 예약 데이터 List
     */
    public List<ReservationData> findAllByUserId(Long userId) {
        return reservationDataRepository.findAllByUserId(userId);
    }

    /**
     * 예약 데이터 추가
     * @param reservationDataDto 추가할 ReservationData 내용
     * @return 추가된 ReservationData
     */
    public ReservationData add(ReservationDataDto reservationDataDto) {
        ReservationData reservationData = new ReservationData();

        reservationData.setUserId(reservationDataDto.getUserId());
        reservationData.setReservationTime(reservationDataDto.getReservationTime());

        reservationDataRepository.save(reservationData);

        return reservationData;
    }

    /**
     * 예약 데이터 갱신
     * @param reservationId 예약 ID
     * @param reservationDataDto 수정할 ReservationData 내용
     * @return 수정된 ReservationData
     */
    public ReservationData update(Long reservationId, ReservationDataDto reservationDataDto) {
        // 예약 데이터 검색
        ReservationData reservationData = reservationDataRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 예약 데이터입니다."));

        // null이 아니면 갱신
        if(reservationDataDto.getUserId() != null) {
            reservationData.setUserId(reservationDataDto.getUserId());
        }
        if(reservationDataDto.getReservationTime() != null) {
            reservationData.setReservationTime(reservationDataDto.getReservationTime());
        }

        return reservationData;
    }

    /**
     * 특정 reservationId의 예약 데이터 제거
     * @param reservationId 예약 ID
     */
    public void deleteByReservationId(Long reservationId) {
        // 예약 데이터 검색
        ReservationData reservationData = reservationDataRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 예약 데이터입니다."));

        // 예약 데이터 제거
        reservationDataRepository.delete(reservationData);
    }

    /**
     * 특정 userId의 예약 데이터 전체 제거
     * @param userId 유저 ID
     */
    public void deleteAllByUserId(Long userId) {
        // 예약 데이터 검색
        List<ReservationData> reservationDataList = reservationDataRepository.findAllByUserId(userId);

        // 예약 데이터 전체 제거
        reservationDataRepository.deleteAll(reservationDataList);
    }
}
