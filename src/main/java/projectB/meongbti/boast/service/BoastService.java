package projectB.meongbti.boast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.boast.dto.BoastSaveDto;
import projectB.meongbti.boast.entity.Boast;
import projectB.meongbti.boast.repository.BoastRepository;
import projectB.meongbti.exception.member.NotExistMember;
import projectB.meongbti.exception.pet.NotExistPet;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;
import projectB.meongbti.pet.entity.Pet;
import projectB.meongbti.pet.repository.PetRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoastService {

    private final BoastRepository boastRepository;

    private final MemberRepository memberRepository;
    private final PetRepository petRepository;

    public Long saveBoast(BoastSaveDto boastSaveDto) {
        //전달 받은 memberId와 petId를 이용하여 정보 조회
        Member member = memberRepository.findById(boastSaveDto.getMemberId()).orElseThrow(() -> new NotExistMember());
        Pet pet = petRepository.findByPetId(boastSaveDto.getPetId()).orElseThrow(() -> new NotExistPet());

        //사진저장부분 로직 추가해야한다.

        Boast boast = Boast.builder()
                .boastDate(LocalDateTime.now())
                .boastContent(boastSaveDto.getBoastContent())
                .member(member)
                .pet(pet)
                .build();

        //자랑하기 등록
        boastRepository.saveBoast(boast);

        return boast.getBoastId();
    }
}
