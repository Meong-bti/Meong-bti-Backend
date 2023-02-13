package projectB.meongbti.pet.entity;

import lombok.*;
import projectB.meongbti.member.entity.Member;
import projectB.meongbti.pet.dto.PetSaveDto;
import projectB.meongbti.pet.dto.PetUpdateDto;

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
    private String petGender;

    @Column(nullable = false)
    private String petNtlz;

    @Column(nullable = false)

    private Double petWeight;

    private String petMbti;

    private String petImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //==비즈니스 메서드==//
    public void updatePet(PetUpdateDto petUpdateDto) {
        this.petName = petUpdateDto.getPetName();
        this.petBreed = petUpdateDto.getPetBreed();
        this.petBday = petUpdateDto.getPetBday();
        this.petGender = petUpdateDto.getPetGender();
        this.petNtlz = petUpdateDto.getPetNtlz();
        this.petWeight = petUpdateDto.getPetWeight();
        this.petImage = petUpdateDto.getPetImage();
    }

}
