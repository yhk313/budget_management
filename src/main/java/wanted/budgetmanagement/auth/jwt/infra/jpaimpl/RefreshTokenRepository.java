package wanted.budgetmanagement.auth.jwt.infra.jpaimpl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenSpecific, Long> {

    Optional<RefreshTokenSpecific> findByToken(UUID token);
}
