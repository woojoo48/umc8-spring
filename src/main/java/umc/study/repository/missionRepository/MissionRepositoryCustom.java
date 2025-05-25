package umc.study.repository.missionRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {

    // 모든 파라미터에 @Param 추가
    @Query("SELECT m FROM Mission m WHERE m.member.id = :memberId")
    List<Mission> findMissionsByMemberId(@Param("memberId") Long memberId);

    List<Mission> findMissionsByMemberId(Long memberId, MissionStatus status);

    @Query("SELECT m FROM Mission m WHERE m.member.id = :memberId AND m.status = :status")
    List<Mission> findMissionsByMemberIdAndStatus(@Param("memberId") Long memberId,
                                                  @Param("status") MissionStatus status);

    @Query("SELECT COUNT(m) FROM Mission m WHERE m.member.id = :memberId")
    int countTotalMissionsByMemberId(@Param("memberId") Long memberId);

    @Query("SELECT COUNT(m) FROM Mission m WHERE m.member.id = :memberId AND m.status = 'COMPLETE'")
    int countCompletedMissionsByMemberId(@Param("memberId") Long memberId);

    @Query("SELECT m FROM Mission m WHERE m.store.region.id = :regionId")
    List<Mission> findMissionsByRegionId(@Param("regionId") Long regionId);
}