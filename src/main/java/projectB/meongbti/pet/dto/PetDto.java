package projectB.meongbti.pet.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class PetDto {

    private Long petId;

    private String petName;

    private String petBreed;

    private LocalDate petBday;

    private String petGender;

    private String petNtlz;

    private Double petWeight;

    private String petMbti;

    private String petImage;

    private Long memberId;
}
