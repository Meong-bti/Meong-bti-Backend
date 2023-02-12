package projectB.meongbti.pet.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import projectB.meongbti.pet.service.PetService;

@SpringBootTest
@Transactional
class PetControllerTest {

    @Autowired
    PetService petService;

    @Test
    void 펫목록조회By멤버ID() {
        //given

        //when

        //then

    }

    @Test
    void 펫조회By펫ID() {


    }

}