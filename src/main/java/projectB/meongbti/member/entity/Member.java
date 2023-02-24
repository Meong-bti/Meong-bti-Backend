package projectB.meongbti.member.entity;

import lombok.*;
import projectB.meongbti.pet.entity.Pet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(exclude = {"memberImage"})
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(unique = true, nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false)
    private String memberNick;
    private String memberImage;


    @OneToMany(mappedBy = "member")
    private List<Pet> petList = new ArrayList<>();


    @Builder
    public Member(String memberEmail, String memberPw, String memberNick, String memberImage) {
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberNick = memberNick;
        this.memberImage = memberImage;
    }


    public void update( String memberNick, String memberPw) {
        this.memberNick= memberNick;
        this.memberPw =  memberPw;
    }


}
