package projectB.meongbti.heart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projectB.meongbti.heart.dto.HeartDto;
import projectB.meongbti.heart.service.HeartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heart")
public class HeartController {

    private final HeartService heartService;

    /**
     * 좋아요 추가
     */
    @PostMapping("/add")
    public Long addHeart(@RequestBody Long memberId, @RequestBody Long boastId) {
        return heartService.addHeart(memberId, boastId);
    }

    /**
     * 좋아요 취소
     */
    @DeleteMapping("/cancel")
    public Long cancelHeart(@RequestBody Long memberId, @RequestBody Long boastId) {
        return heartService.cancelHeart(memberId, boastId);
    }

    /**
     * 멤버ID를 이용하여 좋아요 한 게시글 조회
     */
    @GetMapping("/{memberId}")
    public List<HeartDto> findByMemberId(@PathVariable Long memberId) {
        return heartService.findByMemberId(memberId);
    }

}
