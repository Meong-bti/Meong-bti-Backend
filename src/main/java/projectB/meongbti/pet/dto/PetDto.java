package projectB.meongbti.pet.dto;

import lombok.*;
import projectB.meongbti.pet.entity.Pet;
import projectB.meongbti.pet.entity.PetGender;
import projectB.meongbti.pet.entity.PetNtlz;

import java.time.LocalDate;

@Data
public class PetDto {

    private Long petId;
    private String petName;
    private String petBreed;
    private LocalDate petBday;
    private PetGender petGender;
    private PetNtlz petNtlz;
    private Double petWeight;
    private String petMbti;
    private String petImage;
    private Long memberId;

    public void fromEntity(Pet pet) {
        this.petId = pet.getPetId();
        this.petName = pet.getPetName();
        this.petBreed = pet.getPetBreed();
        this.petBday = pet.getPetBday();
        this.petGender = pet.getPetGender();
        this.petNtlz = pet.getPetNtlz();
        this.petWeight = pet.getPetWeight();
        this.petMbti = pet.getPetMbti();
        this.petImage = pet.getPetImage();
        this.memberId = pet.getMember().getMemberId();
    }
}
