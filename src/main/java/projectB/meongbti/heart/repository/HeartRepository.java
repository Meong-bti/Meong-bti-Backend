package projectB.meongbti.heart.repository;

import projectB.meongbti.heart.entity.Heart;

import java.util.List;
import java.util.Optional;

public interface HeartRepository {

    public void addHeart(Heart heart);

    public void cancelHeart(Heart heart);

    public Optional<Heart> findByMemberAndBoast(Long memberId, Long boastId);

    public List<Heart> findByMemberId(Long memberId);
}
