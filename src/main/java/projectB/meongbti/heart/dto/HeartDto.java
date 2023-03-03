package projectB.meongbti.heart.dto;

import lombok.Data;
import projectB.meongbti.boast.entity.Boast;
import projectB.meongbti.heart.entity.Heart;
import projectB.meongbti.member.entity.Member;

import javax.persistence.*;

@Data
public class HeartDto {

    private Long heartId;

    private Member member;

    private Boast boast;

    public void fromEntity(Heart heart) {
        this.heartId = heart.getHeartId();
        this.member = heart.getMember();
        this.boast = heart.getBoast();
    }
}
