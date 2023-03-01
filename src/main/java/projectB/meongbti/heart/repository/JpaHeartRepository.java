package projectB.meongbti.heart.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import projectB.meongbti.heart.entity.Heart;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaHeartRepository implements HeartRepository {

    private final EntityManager em;

    /**
     * 좋아요 추가
     */
    @Override
    public void addHeart(Heart heart) {
        em.persist(heart);
    }

    /**
     * 좋아요 삭제
     */
    @Override
    public void cancelHeart(Heart heart) {
        em.remove(heart);
    }

    /**
     * 좋아요 정보 조회 By MemberId And BoastId
     */
    @Override
    public Optional<Heart> findByMemberAndBoast(Long memberId, Long boastId) {
        String jpql = "select h from Heart h where h.member.memberId = :memberId and h.boast.boastId = :boastId";

        return em.createQuery(jpql, Heart.class)
                .setParameter("memberId", memberId)
                .setParameter("boastId", boastId)
                .getResultList()
                .stream().findAny();
    }
}
