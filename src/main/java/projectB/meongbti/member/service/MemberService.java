package projectB.meongbti.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import projectB.meongbti.member.dto.MemberJoinRequestDto;
import projectB.meongbti.member.dto.MemberJoinResponseDto;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.repository.MemberRepository;
import projectB.meongbti.util.image.Entity.ImageMapping;
import projectB.meongbti.util.image.ImageStore;
import projectB.meongbti.util.image.repository.ImageRepository;

import java.io.IOException;

@Service
@Log4j2
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ImageStore imageStore;
    private final ImageRepository imageRepository;


    @PostMapping("/signup")
    public ResponseEntity<MemberJoinResponseDto> memberSignup(MemberJoinRequestDto memberJoinRequestDTO) throws IOException {

        String FullPath = "";
        if(!memberJoinRequestDTO.getMemberImage().isEmpty()){

            ImageMapping imageMapping = imageStore.storeFile(memberJoinRequestDTO.getMemberImage());
            FullPath = imageStore.getFullPath(imageMapping.getImStore());
            imageRepository.save(imageMapping);

        }
        Member  member = Member.builder()
                .memberEmail(memberJoinRequestDTO.getMemberEmail())
                .memberPw(memberJoinRequestDTO.getMemberPw())
                .memberNick(memberJoinRequestDTO.getMemberNick())
                .memberImage(FullPath)
                .build();
        memberRepository.save(member);

        return ResponseEntity.ok().body(MemberJoinResponseDto.builder()
                .memberEmail(member.getMemberEmail())
                .memberNick(member.getMemberNick())
                .memberImage(FullPath)
                .build());

    }

//    /**
//     * 회원 수정
//     */

//    public MemberDto updateMember(Long id, MemberDto memberDto){
//        Member member = memberRepository.findById(id).orElseThrow(() -> new NotExistMember());
//
//        String FullPath = "";
//        if()
//        member.update( memberDto.getMemberNick(),memberDto.getMemberImage(), memberDto.getMemberPw());
//        memberRepository.save(member);
//        return MemberDto.toDto(member);
//
//
//    }

        /**
         * 회원 삭제
         */

//
//    public void deleteMember(Long id){
//
//        Member member = memberRepository.findById(id).orElseThrow(() -> new NotExistMember());
//        memberRepository.delete(member);
//
//
//
//    }
//    /**
//     * 회원 조회
//     */
//
//    public MemberDto findByid(Long id) {
//        Member member = memberRepository.findById(id)
//                .orElseThrow(() -> new NotExistMember());
//        return toDto(member);
//    }
//
//    public  MemberDto toDto(Member member) {
//
//        return MemberDto.builder()
//                .memberEmail(member.getMemberEmail())
//                .memberPw(member.getMemberPw())
//                .memberNick(member.getMemberNick())
//                .memberImage(member.getMemberImage())
//                .build();
//    }
//
//}

}