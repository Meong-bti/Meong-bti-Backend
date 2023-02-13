package projectB.meongbti.pet.controller;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;
import projectB.meongbti.pet.dto.PetDto;
import projectB.meongbti.pet.dto.PetSaveDto;
import projectB.meongbti.pet.service.PetService;

import java.time.LocalDate;

@SpringBootTest
@Transactional
class PetControllerTest {

    @Autowired
    PetService petService;
    @Autowired
    MemberRepository memberRepository;

    @DisplayName("펫 등록")
    @Test
    void petSave() {
        //given
        Member member = Member.builder()
                .memberEmail("test@test.com")
                .memberPw("test")
                .memberPhone("010-0000-0000")
                .memberNick("test")
                .build();
        memberRepository.save(member);

        PetSaveDto petSaveDto = PetSaveDto.builder()
                .petName("test")
                .petBreed("골든리트리버")
                .petBday(LocalDate.now())
                .petGender("MALE")
                .petNtlz("NTLZ")
                .petWeight(11.11)
                .memberId(member.getMemberId())
                .build();

        //when
        Long petId = petService.savePet(petSaveDto);

        //then
        PetDto petDto = petService.findOneByPetId(petId);

        Assertions.assertThat(petId).isEqualTo(petDto.getPetId());
    }

    @DisplayName("펫 삭제")
    @Test
    void deletePet() {
        //given

        //when

        //then
    }

    @DisplayName("펫 수정")
    @Test
    void petUpdate() {
        //given

        //when

        //then

    }

    @DisplayName("펫조회By펫Id")
    @Test
    void findOne() {


    }

}