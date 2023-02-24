package projectB.meongbti.exception.member;

public class NotExistMember extends RuntimeException {

    public NotExistMember() {
        super("존재하지 않는 회원입니다.");
    }
}
