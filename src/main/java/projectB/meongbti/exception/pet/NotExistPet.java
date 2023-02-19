package projectB.meongbti.exception.pet;

public class NotExistPet extends RuntimeException {

    public NotExistPet() {
        super("존재하지 않는 반려동물 입니다.");
    }

}
