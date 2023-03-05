package projectB.meongbti.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import projectB.meongbti.member.dto.request.MemberJoinRequestDto;
import projectB.meongbti.member.dto.response.MemberJoinResponse;
import projectB.meongbti.member.dto.response.Response;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.member.service.MemberService;

import java.io.IOException;


@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;



    @PostMapping("/signup")
    public Response<MemberJoinResponse> memberSignup(@RequestBody
                                                              MemberJoinRequestDto requestDto)  {
        Member member = memberService.signup(requestDto.getMemberEmail(), requestDto.getMemberPw(), requestDto.getMemberName());
        return Response.success(MemberJoinResponse.fromMember(member));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
//        memberService.deleteMember(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<MemberDto.Response> findByid(@PathVariable Long id){
//        return ResponseEntity.ok().body(memberService.findByid(id));
//    }







//    @PatchMapping("/{id}")
//    public ResponseEntity<MemberDto> updateMember(@PathVariable Long id, @RequestBody MemberDto memberDto){
//        MemberDto updateMemberDto = memberService.updateMember(id, memberDto);
//        return ResponseEntity.ok().body(updateMemberDto);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
//        memberService.deleteMember(id);
//        return ResponseEntity.ok().build();
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<MemberDto> findByid(@PathVariable Long id){
//        return ResponseEntity.ok().body(memberService.findByid(id));
//    }



//    @PostMapping("/fileSystem")
//    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
//        String uploadImage = storageService.uploadImageToFileSystem(file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
//
//    @GetMapping("/fileSystem/{fileName}")
//    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
//        byte[] imageData=storageService.downloadImageFromFileSystem(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);

    }


