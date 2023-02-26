package projectB.meongbti.boast.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.pet.entity.Pet;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class BoastSaveDto {

    private String boastContent;

    private MultipartFile boastImage;

    private Long memberId;

    private Long petId;
}
