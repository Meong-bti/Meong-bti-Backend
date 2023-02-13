package projectB.meongbti.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PetUpdateDto {

    private String petName;

    private String petBreed;

    private LocalDate petBday;

    private String petGender;

    private String petNtlz;

    private Double petWeight;

    private String petImage;

}
