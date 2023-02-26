package projectB.meongbti.heart.entity;

import lombok.*;
import projectB.meongbti.boast.entity.Boast;
import projectB.meongbti.member.entity.Member;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Heart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boast_id")
    private Boast boast;
}
