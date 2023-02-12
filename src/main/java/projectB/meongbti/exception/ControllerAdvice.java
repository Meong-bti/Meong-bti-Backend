package projectB.meongbti.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import projectB.meongbti.exception.pet.NotExistPet;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotExistPet.class)
    public ResponseEntity<Map<String, String>> notExistPet(NotExistPet e) {
        log.error("##### NotExistPet 에러 발생 #####");

        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

}
