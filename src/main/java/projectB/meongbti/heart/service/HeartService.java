package projectB.meongbti.heart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.boast.entity.Boast;
import projectB.meongbti.boast.repository.BoastRepository;
import projectB.meongbti.heart.dto.HeartDto;
import projectB.meongbti.heart.entity.Heart;
import projectB.meongbti.heart.repository.HeartRepository;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

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
     * 좋아요 취소
     */
    public Long cancelHeart(Long memberId, Long boastId) {
        //멤버ID와 자랑하기ID를 이용하여 좋아요 정보 조회
        Heart heart = heartRepository.findByMemberAndBoast(memberId, boastId).get();

        heartRepository.cancelHeart(heart);

        return heart.getHeartId();
    }

    /**
     * 멤버ID를 이용하여 좋아요 한 자랑하기 게시글 조회
     */
    @Transactional(readOnly = true)
    public List<HeartDto> findByMemberId(Long memberId) {
        //멤버ID를 이용하여 좋아요한 게시글 조회
        List<Heart> findHeart = heartRepository.findByMemberId(memberId);

        List<HeartDto> returnList = new ArrayList<>();
        findHeart.forEach(heart -> {
            HeartDto heartDto = new HeartDto();
            heartDto.entityToDto(heart);
            returnList.add(heartDto);
        });

        return returnList;
    }
}

