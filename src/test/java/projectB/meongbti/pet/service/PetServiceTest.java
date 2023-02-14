package projectB.meongbti.pet.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.exception.pet.NotExistPet;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;
import projectB.meongbti.pet.dto.PetDto;
import projectB.meongbti.pet.dto.PetSaveDto;
import projectB.meongbti.pet.dto.PetUpdateDto;
import projectB.meongbti.pet.entity.Pet;
import projectB.meongbti.pet.repository.PetRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Slf4j
class PetServiceTest {

    @Autowired
    PetService petService;
    @Autowired
    PetRepository petRepository;
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
        Pet pet = petRepository.findByPetId(petId).get();

        Assertions.assertThat(petSaveDto.getPetName()).isEqualTo(pet.getPetName());
        Assertions.assertThat(petSaveDto.getPetBreed()).isEqualTo(pet.getPetBreed());
        Assertions.assertThat(petSaveDto.getPetBday()).isEqualTo(pet.getPetBday());
        Assertions.assertThat(petSaveDto.getPetGender()).isEqualTo(pet.getPetGender());
        Assertions.assertThat(petSaveDto.getPetNtlz()).isEqualTo(pet.getPetNtlz());
        Assertions.assertThat(petSaveDto.getPetWeight()).isEqualTo(pet.getPetWeight());
        Assertions.assertThat(petSaveDto.getMemberId()).isEqualTo(pet.getMember().getMemberId());
    }

    @DisplayName("펫 삭제")
    @Test
    void deletePet() {
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
        petService.deletePet(petId);

        Assertions.assertThatThrownBy(() -> petService.findOneByPetId(petId)).isInstanceOf(NotExistPet.class);
    }

    @DisplayName("펫 수정")
    @Test
    void petUpdate() {
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

        Long petId = petService.savePet(petSaveDto);

        PetUpdateDto petUpdateDto = PetUpdateDto.builder()
                .petName("updateTest")
                .petBreed("말라뮤트")
                .petBday(LocalDate.now())
                .petGender("FEMALE")
                .petNtlz("NONE")
                .petWeight(22.22)
                .build();

        //when
        Long findPetId = petService.updatePet(petId, petUpdateDto);
        Pet pet = petRepository.findByPetId(findPetId).get();

        //then
        Assertions.assertThat(petUpdateDto.getPetName()).isEqualTo(pet.getPetName());
        Assertions.assertThat(petUpdateDto.getPetBreed()).isEqualTo(pet.getPetBreed());
        Assertions.assertThat(petUpdateDto.getPetBday()).isEqualTo(pet.getPetBday());
        Assertions.assertThat(petUpdateDto.getPetGender()).isEqualTo(pet.getPetGender());
        Assertions.assertThat(petUpdateDto.getPetNtlz()).isEqualTo(pet.getPetNtlz());
        Assertions.assertThat(petUpdateDto.getPetWeight()).isEqualTo(pet.getPetWeight());
    }

    @DisplayName("펫조회By펫Id")
    @Test
    void findOneByPetId() {
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
        PetDto findPetDto = petService.findOneByPetId(petId);

        Assertions.assertThat(petSaveDto.getPetName()).isEqualTo(findPetDto.getPetName());
        Assertions.assertThat(petSaveDto.getPetBreed()).isEqualTo(findPetDto.getPetBreed());
        Assertions.assertThat(petSaveDto.getPetBday()).isEqualTo(findPetDto.getPetBday());
        Assertions.assertThat(petSaveDto.getPetGender()).isEqualTo(findPetDto.getPetGender());
        Assertions.assertThat(petSaveDto.getPetNtlz()).isEqualTo(findPetDto.getPetNtlz());
        Assertions.assertThat(petSaveDto.getPetWeight()).isEqualTo(findPetDto.getPetWeight());
        Assertions.assertThat(petSaveDto.getMemberId()).isEqualTo(findPetDto.getMemberId());
    }


    @DisplayName("펫목록조회By멤버Id")
    @Test
    void findAllMemberId (){
        //given
        Member member = Member.builder()
                .memberEmail("test@test.com")
                .memberPw("test")
                .memberPhone("010-0000-0000")
                .memberNick("test")
                .build();
        memberRepository.save(member);

        PetSaveDto petSaveDto1 = PetSaveDto.builder()
                .petName("test")
                .petBreed("골든리트리버")
                .petBday(LocalDate.now())
                .petGender("MALE")
                .petNtlz("NTLZ")
                .petWeight(11.11)
                .memberId(member.getMemberId())
                .build();

        PetSaveDto petSaveDto2 = PetSaveDto.builder()
                .petName("test2")
                .petBreed("말라뮤트")
                .petBday(LocalDate.now())
                .petGender("FEMALE")
                .petNtlz("NONE")
                .petWeight(22.22)
                .memberId(member.getMemberId())
                .build();

        //when
        petService.savePet(petSaveDto1);
        petService.savePet(petSaveDto2);

        //then
        List<PetDto> findPets = petService.findAllByMemberId(member.getMemberId());

        Assertions.assertThat(findPets.size()).isEqualTo(2);
    }

}