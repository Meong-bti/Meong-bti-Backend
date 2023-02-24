package projectB.meongbti.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
public  class MemberJoinResponseDto{

    private Long memberId;
    private String memberEmail;
    private String memberNick;
    private String memberImage;

    @Builder
    public MemberJoinResponseDto(Long memberId, String memberEmail, String memberNick, String memberImage) {

        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberNick = memberNick;
        this.memberImage = memberImage;


    }
}