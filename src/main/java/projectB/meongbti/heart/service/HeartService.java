package projectB.meongbti.heart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.boast.entity.Boast;
import projectB.meongbti.boast.repository.BoastRepository;
import projectB.meongbti.heart.entity.Heart;
import projectB.meongbti.heart.repository.HeartRepository;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartService {

    private final HeartRepository heartRepository;

    private final MemberRepository memberRepository;
    private final BoastRepository boastRepository;

    /**
     * 좋아요 추가
     */
    public Long addHeart(Long memberId, Long boastId) {
        //멤버ID와 게시글ID를 조회
        Member member = memberRepository.findById(memberId).get();
        Boast boast = boastRepository.findOne(boastId).get();

        Heart heart = Heart.builder()
                .member(member)
                .boast(boast)
                .build();

        heartRepository.addHeart(heart);

        return heart.getHeartId();
    }

    /**
     * 좋아요 삭제
     */
    public Long cancelHeart(Long memberId, Long boastId) {
        //멤버ID와 자랑하기ID를 이용하여 좋아요 정보 조회
        Heart heart = heartRepository.findByMemberAndBoast(memberId, boastId).get();

        heartRepository.cancelHeart(heart);

        return heart.getHeartId();
    }
}

