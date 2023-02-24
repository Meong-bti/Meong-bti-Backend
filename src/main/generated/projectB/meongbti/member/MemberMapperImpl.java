package projectB.meongbti.member;

import javax.annotation.processing.Generated;
import org.springframework.web.multipart.MultipartFile;
import projectB.meongbti.member.dto.MemberJoinRequestDto;
import projectB.meongbti.member.dto.MemberJoinResponseDto;
import projectB.meongbti.member.entity.Member;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-23T19:08:38+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberJoinResponseDto toMemberResponseDTO(Member member) {
        if ( member == null ) {
            return null;
        }

        Long memberId = null;
        String memberEmail = null;
        String memberNick = null;
        String memberImage = null;

        MemberJoinResponseDto memberJoinResponseDto = new MemberJoinResponseDto( memberId, memberEmail, memberNick, memberImage );

        return memberJoinResponseDto;
    }

    @Override
    public MemberJoinRequestDto toMemberRequestDTO(Member member) {
        if ( member == null ) {
            return null;
        }

        String memberEmail = null;
        String memberPw = null;
        String memberNick = null;
        MultipartFile memberImage = null;

        MemberJoinRequestDto memberJoinRequestDto = new MemberJoinRequestDto( memberEmail, memberPw, memberNick, memberImage );

        return memberJoinRequestDto;
    }

    @Override
    public Member joinRequestDTOToMember(MemberJoinRequestDto memberJoinRequestDTO) {
        if ( memberJoinRequestDTO == null ) {
            return null;
        }

        String memberEmail = null;
        String memberPw = null;
        String memberNick = null;
        String memberImage = null;

        Member member = new Member( memberEmail, memberPw, memberNick, memberImage );

        return member;
    }

    @Override
    public Member joinResponseDtoToMember(MemberJoinResponseDto memberJoinResponseDto) {
        if ( memberJoinResponseDto == null ) {
            return null;
        }

        String memberEmail = null;
        String memberPw = null;
        String memberNick = null;
        String memberImage = null;

        Member member = new Member( memberEmail, memberPw, memberNick, memberImage );

        return member;
    }
}
