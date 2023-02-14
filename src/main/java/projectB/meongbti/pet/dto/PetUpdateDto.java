package projectB.meongbti.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class PetUpdateDto {

    private String petName;

    private String petBreed;

    private LocalDate petBday;

    private String petGender;

    private String petNtlz;

    private Double petWeight;

    private String petImage;

}
