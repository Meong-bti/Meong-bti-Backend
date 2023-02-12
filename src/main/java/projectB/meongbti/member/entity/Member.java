package projectB.meongbti.member.entity;

import lombok.*;
import projectB.meongbti.member.dto.MemberDto;
import projectB.meongbti.pet.entity.Pet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true, nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false)
    private String memberPhone;

    @Column(nullable = false)
    private String memberNick;

    private String memberImage;


    @OneToMany(mappedBy = "member")
    private List<Pet> petList = new ArrayList<>();

    @Builder
    public Member(String memberEmail, String memberPw, String memberPhone, String memberNick, String memberImage) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberPhone = memberPhone;
        this.memberNick = memberNick;
        this.memberImage = memberImage;
    }

    public static Member toEntity(MemberDto memberDto){
        return Member.builder()
                .memberEmail(memberDto.getMemberEmail())
                .memberPw(memberDto.getMemberPw())
                .memberPhone(memberDto.getMemberPhone())
                .memberNick(memberDto.getMemberNick())
                .memberImage(memberDto.getMemberImage())
                .build();


    }

    public void update(String memberPhone, String memberNick, String memberImage, String memberPw) {

        this.memberPhone = memberPhone;
        this.memberNick= memberNick;
        this.memberImage = memberImage;
        this.memberPw =  memberPw;

    }

    public void changePassword(String newPassword) {
        this.memberPw = newPassword;
    }

}
