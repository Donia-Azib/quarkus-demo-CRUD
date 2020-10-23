package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
