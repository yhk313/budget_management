package wanted.budgetmanagement.auth.jwt.infra.jpaimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wanted.budgetmanagement.auth.jwt.domain.RefreshToken;
import wanted.budgetmanagement.auth.jwt.domain.RefreshTokenManager;
import wanted.budgetmanagement.auth.jwt.domain.exception.RefreshTokenNotFoundException;
import wanted.budgetmanagement.config.JwtProperties;

import java.util.UUID;

@Component
@Transactional
@RequiredArgsConstructor
public class JpaRefreshTokenManager implements RefreshTokenManager {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Override
    public RefreshToken issue(Long memberId, String memberName) {
        RefreshTokenSpecific saved = refreshTokenRepository.save(
            RefreshTokenSpecific.create(
                memberId,
                memberName,
                jwtProperties.getRefreshTokenLifespanInMinutes())
        );

        return saved.convert();
    }

    @Override
    public RefreshToken renew(String refreshToken, String username) {
        RefreshTokenSpecific found = refreshTokenRepository.findByToken(UUID.fromString(refreshToken))
                                         .orElseThrow(() -> RefreshTokenNotFoundException.INSTANCE);
        found.renew(jwtProperties.getRefreshTokenLifespanInMinutes(), username);

        return found.convert();
    }
}
