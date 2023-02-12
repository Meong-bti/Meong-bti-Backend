package projectB.meongbti.pet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projectB.meongbti.pet.dto.PetDto;
import projectB.meongbti.pet.dto.PetSaveDto;
import projectB.meongbti.pet.dto.PetUpdateDto;
import projectB.meongbti.pet.service.PetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    /**
     * 펫 등록
     */
    @PostMapping()
    public Long savePet(@RequestBody PetSaveDto petSaveDto) {
        return petService.savePet(petSaveDto);
    }

    /**
     * 펫 수정
     */
    @PatchMapping("/update/{petId}")
    public Long updatePet(@PathVariable Long petId, @RequestBody PetUpdateDto petUpdateDto) {
        return petService.updatePet(petId, petUpdateDto);
    }

    /**
     * 펫 삭제
     */
    @DeleteMapping("/delete/{petId}")
    public Long DeletePet(@PathVariable Long petId) {
        return 1L;
    }

    /**
     * 멤버ID를 이용하여 멤버의 애완동물을 조회
     */
    @GetMapping("/member/{memberId}")
    public List<PetDto> findBymemberId(@PathVariable Long memberId) {
        return petService.findBymemberId(memberId);
    }

    /**
     * 펫ID를 이용하여 펫 정보 조회
     */
    @GetMapping("/{petId}")
    public PetDto findByPetId(@PathVariable Long petId) {
        return petService.findByPetId(petId);
    }

}
