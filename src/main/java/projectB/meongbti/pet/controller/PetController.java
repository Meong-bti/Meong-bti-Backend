package projectB.meongbti.pet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectB.meongbti.pet.dto.PetDto;
import projectB.meongbti.pet.service.PetSerivce;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {

    private final PetSerivce petSerivce;

    /**
     * 멤버ID를 이용하여 멤버의 애완동물을 조회
     */
    @GetMapping("/member/{memberId}")
    public List<PetDto> findBymemberId(@PathVariable Long memberId) {
        return petSerivce.findBymemberId(memberId);
    }

    /**
     * 펫ID를 이용하여 펫 정보 조회
     */
    @GetMapping("/{petId}")
    public PetDto findByPetId(@PathVariable Long petId) {
        return petSerivce.findByPetId(petId);
    }

}
