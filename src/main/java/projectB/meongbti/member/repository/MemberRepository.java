package projectB.meongbti.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectB.meongbti.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberEmail(String memberEmail);
}
