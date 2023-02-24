package projectB.meongbti.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import projectB.meongbti.member.dto.MemberJoinRequestDto;
import projectB.meongbti.member.dto.MemberJoinResponseDto;
import projectB.meongbti.member.service.MemberService;
import projectB.meongbti.member.service.StorageService;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final StorageService storageService;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData=storageService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

    @PostMapping("/signup")
    public ResponseEntity<MemberJoinResponseDto> memberSignup(@RequestBody @Valid
                                                              MemberJoinRequestDto memberJoinRequestDTO) throws IOException {
        ResponseEntity<MemberJoinResponseDto> signup = memberService.memberSignup(memberJoinRequestDTO);
        return ResponseEntity.ok().body(signup.getBody());
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


}
