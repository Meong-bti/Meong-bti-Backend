package projectB.meongbti.pet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.exception.pet.NotExistPet;
import projectB.meongbti.pet.dto.PetDto;
import projectB.meongbti.pet.entity.Pet;
import projectB.meongbti.pet.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetSerivce {

    private final PetRepository petRepository;

    /**
     * 멤버ID를 이용하여 멤버의 애완동물을 조회
     */
    @Transactional(readOnly = true)
    public List<PetDto> findBymemberId(Long memberId) {
        List<Pet> findPets = petRepository.findBymemberId(memberId);

        List<PetDto> returnList = new ArrayList<>();

        findPets.stream().forEach(pet -> {
            PetDto petDto = EntityToDto(pet);
            returnList.add(petDto);
        });

        return returnList;
    }

    /**
     * 펫ID를 이용하여 펫 정보 조회
     */
    public PetDto findByPetId(Long petId) {
        Pet pet = petRepository.findByPetId(petId)
                .orElseThrow(() -> new NotExistPet());

        return EntityToDto(pet);
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
                .petSex(pet.getPetSex())
                .petNtlz(pet.getPetNtlz())
                .petWeight(pet.getPetWeight())
                .petMbti(pet.getPetMbti())
                .petImage(pet.getPetImage())
                .memberId(pet.getMember().getMemberId())
                .build();
    }
}
