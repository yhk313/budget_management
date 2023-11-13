package wanted.budgetmanagement.auth.authmember.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthMemberRepository extends JpaRepository<AuthMember, Long> {
    Optional<AuthMember> findByUsername(String username);
}