package projectB.meongbti.member;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import projectB.meongbti.member.dto.MemberJoinRequestDto;
import projectB.meongbti.member.dto.MemberJoinResponseDto;
import projectB.meongbti.member.entity.Member;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberJoinResponseDto toMemberResponseDTO(Member member);
    MemberJoinRequestDto toMemberRequestDTO(Member member);
    Member joinRequestDTOToMember(MemberJoinRequestDto memberJoinRequestDTO);
    Member joinResponseDtoToMember(MemberJoinResponseDto memberJoinResponseDto);
}