package projectB.meongbti.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
public class MemberJoinRequestDto {
    private String memberEmail;
    private String memberPw;
    private String memberNick;
    private MultipartFile memberImage;

    @Builder
    public MemberJoinRequestDto(String memberEmail, String memberPw, String memberNick, MultipartFile  memberImage) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberNick = memberNick;
        this.memberImage = memberImage;
    }






}
