package projectB.meongbti.pet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.exception.pet.NotExistPet;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;
import projectB.meongbti.pet.dto.PetDto;
import projectB.meongbti.pet.dto.PetSaveDto;
import projectB.meongbti.pet.dto.PetUpdateDto;
import projectB.meongbti.pet.entity.Pet;
import projectB.meongbti.pet.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final MemberRepository memberRepository;

    /**
     * 펫등록
     */
    public Long savePet(PetSaveDto petSaveDto) {
        //전달 받은 memberId를 통해 member 정보 조회
        Member member = memberRepository.findById(petSaveDto.getMemberId()).get();

        //사진 저장하는거 보고 넣어야 함.

        //조회한 member를 pet 엔티티에 저장
        Pet pet = Pet.builder()
                .petName(petSaveDto.getPetName())
                .petBreed(petSaveDto.getPetBreed())
                .petBday(petSaveDto.getPetBday())
                .petGender(petSaveDto.getPetGender())
                .petNtlz(petSaveDto.getPetNtlz())
                .petWeight(petSaveDto.getPetWeight())
                .petImage(petSaveDto.getPetImage())
                .member(member)
                .build();

        //펫 등록
        petRepository.savePet(pet);

        return pet.getPetId();
    }

    /**
     * 펫 삭제
     */
    public Long deletePet(Long petId) {
        //삭제 어떻게 할지 정해야함.
        return 1L;
    }

    /**
     * 펫 수정
     */
    public Long updatePet(Long petId, PetUpdateDto petUpdateDto) {
        //petId를 이용하여 펫 정보를 우선적으로 조회
        //펫 정보가 없으면 NotExistPet 예외를 발생시킨다.
        Pet pet = petRepository.findByPetId(petId).orElseThrow(() -> new NotExistPet());

        //펫 정보를 업데이트
        pet.updatePet(petUpdateDto);

        return pet.getPetId();
    }

    /**
     * 펫ID를 이용하여 펫 정보 조회
     */
    public PetDto findOneByPetId(Long petId) {
        Pet pet = petRepository.findByPetId(petId)
                .orElseThrow(() -> new NotExistPet());

        return EntityToDto(pet);
    }

    /**
     * 멤버ID를 이용하여 멤버의 애완동물을 조회
     */
    @Transactional(readOnly = true)
    public List<PetDto> findAllByMemberId(Long memberId) {
        List<Pet> findPets = petRepository.findBymemberId(memberId);

        List<PetDto> returnList = new ArrayList<>();

        findPets.stream().forEach(pet -> {
            PetDto petDto = EntityToDto(pet);
            returnList.add(petDto);
        });

        return returnList;
    }

    /**
     * 펫 Entity -> Dto
     */
    public PetDto EntityToDto(Pet pet) {
        return PetDto.builder()
                .petId(pet.getPetId())
                .petName(pet.getPetName())
                .petBreed(pet.getPetBreed())
                .petBday(pet.getPetBday())
                .petGender(pet.getPetGender())
                .petNtlz(pet.getPetNtlz())
                .petWeight(pet.getPetWeight())
                .petMbti(pet.getPetMbti())
                .petImage(pet.getPetImage())
                .memberId(pet.getMember().getMemberId())
                .build();
    }
}
