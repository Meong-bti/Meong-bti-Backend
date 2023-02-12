package projectB.meongbti.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import projectB.meongbti.member.entity.Member;

@NoArgsConstructor
@Getter
public class MemberDto {
    private String memberEmail;
    private String memberPw;

    private String memberPhone;
    private String memberNick;
    private String memberImage;

    @Builder
    public MemberDto(String memberEmail, String memberPw, String memberPhone, String memberNick, String memberImage) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberPhone = memberPhone;
        this.memberNick = memberNick;
        this.memberImage = memberImage;
    }


    public static MemberDto toDto(Member member) {

        return MemberDto.builder()
                .memberEmail(member.getMemberEmail())
                .memberPw(member.getMemberPw())
                .memberPhone(member.getMemberPhone())
                .memberNick(member.getMemberNick())
                .memberImage(member.getMemberImage())
                .build();
    }

    public static class Response{

        private Long memberId;
        private String memberEmail;
        private String memberPhone;
        private String memberNick;
        private String memberImage;
@Builder
        public Response (Long memberId, String memberEmail, String memberPhone, String memberNick, String memberImage){

            this.memberId = memberId;
            this.memberEmail = memberEmail;
            this.memberPhone = memberPhone;
            this.memberNick = memberNick;
            this.memberImage = memberImage;




        }

    }

      public static Response toResponseDto(Member member){
        return new Response(member.getMemberId(), member.getMemberEmail(), member.getMemberPhone(), member.getMemberNick(), member.getMemberImage());



    }

    public String getMemberPw() {
        return memberPw;
    }





}
