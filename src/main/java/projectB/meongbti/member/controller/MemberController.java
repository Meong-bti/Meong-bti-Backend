package projectB.meongbti.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectB.meongbti.member.dto.MemberDto;
import projectB.meongbti.member.service.MemberService;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<MemberDto> join(@RequestBody MemberDto memberDto){
        MemberDto joinMemberDto =  memberService.join(memberDto);
        return ResponseEntity.ok().body(joinMemberDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable Long id, @RequestBody MemberDto memberDto){
        MemberDto updateMemberDto = memberService.updateMember(id, memberDto);
        return ResponseEntity.ok().body(updateMemberDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto.Response> findByid(@PathVariable Long id){
        return ResponseEntity.ok().body(memberService.findByid(id));
    }
//    @GetMapping(value = "/members/{id}/profile-image")
//    public ResponseEntity<byte[]> getProfileImage(@PathVariable Long id) {
//        Member member = memberService.getMemberById(id);
//        byte[] imageData = member.getProfileImage();
//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_JPEG);
//        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
//    }

//    @GetMapping("/email/{email}")
//    public ResponseEntity<MemberDto.Response> findByEmail(@PathVariable String email) {
//        return ResponseEntity.ok(memberService.findByEmail(email));
//    }
//
//    @PatchMapping("/{id}/pw")
//    public ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestBody MemberDto.ChangePassword memberDto) {
//        memberService.changePassword(id, memberDto);
//        return ResponseEntity.ok().build();
//    }

}
