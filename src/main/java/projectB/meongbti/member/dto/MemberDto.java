package projectB.meongbti.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
public class MemberDto {
    private String memberEmail;
    private String memberPw;
    private String memberNick;
    private String memberImage;

    @Builder
    public MemberDto(String memberEmail, String memberPw,  String memberNick, String memberImage) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberNick = memberNick;
        this.memberImage = memberImage;
    }


    }



