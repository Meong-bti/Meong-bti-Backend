package projectB.meongbti.exception.member;

public class NotExistMember extends RuntimeException {

    public NotExistMember(Long message) {
        super("존재하지 않는 회원입니다. 회원ID: " + message);
    }
}
