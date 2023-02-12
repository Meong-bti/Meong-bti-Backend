package projectB.meongbti.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PetSaveDto {

    private String petName;

    private String petBreed;

    private LocalDate petBday;

    private Character petSex;

    private Character petNtlz;

    private Double petWeight;

    private String petImage;

    private Long memberId;

}

