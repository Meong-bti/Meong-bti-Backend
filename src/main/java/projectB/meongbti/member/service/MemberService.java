package projectB.meongbti.member.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectB.meongbti.member.dto.MemberDto;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDto join(MemberDto memberDto) {

        Member member = Member.toEntity(memberDto);
        memberRepository.save(member);
        return MemberDto.toDto(member);


    }

    public MemberDto updateMember(Long id, MemberDto memberDto){
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + id));
        member.update(memberDto.getMemberPhone(), memberDto.getMemberNick(),memberDto.getMemberImage(), memberDto.getMemberPw());
        memberRepository.save(member);
        return MemberDto.toDto(member);


    }

    public void deleteMember(Long id){

        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + id));
        memberRepository.delete(member);



    }
    public MemberDto.Response findByid(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No such member"));
        return MemberDto.toResponseDto(member);
    }
//
//    public MemberDto.Response findByEmail(String email){
//        Member member = memberRepository.findByMemberEmail(email)
//                .orElseThrow(() -> new IllegalArgumentException("No such member"));
//        return MemberDto.toResponseDto(member);
//
//
//    }
//
//    public void changePassword(Long id, MemberDto.changePassword memberDto){
//        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + id));
//        member.changePassword(memberDto.getMemberPw());
//        memberRepository.save(member);
//    }


}
