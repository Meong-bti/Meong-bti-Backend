package projectB.meongbti.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import projectB.meongbti.exception.member.MemberException;
import projectB.meongbti.exception.pet.NotExistPet;
import projectB.meongbti.member.dto.response.Response;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    /**
     * Member 관련 Exception
     */
//    @ExceptionHandler(MemberException.class)
//    public ResponseEntity<?> MemberHandler(MemberException e) {
//
//        return ResponseEntity.status(e.getErrorCode().getStatus())
//                .body(Response.error(e.getErrorCode().name()));
//    }

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<Map<String, String>> MemberHandler(MemberException e) {
        Map<String, String> error = new HashMap<>();

        error.put("message", e.getMessage());

        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(error);
    }

    /**
     * Pet 관련 Exception
     */
    @ExceptionHandler(NotExistPet.class)
    public ResponseEntity<Map<String, String>> notExistPet(NotExistPet e) {
        log.error("##### NotExistPet 에러 발생 #####");

        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }


}
