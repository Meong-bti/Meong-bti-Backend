package projectB.meongbti.pet.entity;

import lombok.*;
import projectB.meongbti.member.entity.Member;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Pet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @Column(nullable = false)
    private String petName;

    @Column(nullable = false)
    private String petBreed;

    @Column(nullable = false)
    private LocalDate petBday;

    @Column(nullable = false)
    private Character petSex;

    @Column(nullable = false)
    private Character petNtlz;

    @Column(nullable = false)

    private Double petWeight;

    private String petMbti;


    private String petImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
