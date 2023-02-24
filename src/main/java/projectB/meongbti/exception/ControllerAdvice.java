package projectB.meongbti.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import projectB.meongbti.exception.member.MemberJoinException;
import projectB.meongbti.exception.member.NotExistMember;
import projectB.meongbti.exception.pet.NotExistPet;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    /**
     * Member 관련 Exception
     */
    @ExceptionHandler(NotExistMember.class)
    public ResponseEntity<Map<String, String>> notExistMember(NotExistMember e) {
        log.error("##### NotExistMember 에러 발생 #####");

        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
    /**
     * Member 등록 Exception
     */
    @ExceptionHandler(MemberJoinException.class)
    public ResponseEntity<Map<String, String>> memberJoinException(MemberJoinException e) {
        log.error("##### MemberJoinException 에러 발생 #####");

        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());

        return ResponseEntity.badRequest().body(error);
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
