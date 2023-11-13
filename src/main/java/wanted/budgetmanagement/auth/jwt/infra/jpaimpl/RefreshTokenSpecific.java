package wanted.budgetmanagement.auth.jwt.infra.jpaimpl;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.budgetmanagement.auth.jwt.domain.RefreshToken;
import wanted.budgetmanagement.auth.jwt.domain.exception.RefreshTokenExpirationException;
import wanted.budgetmanagement.auth.jwt.domain.exception.RefreshTokenRenewException;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * id 는 지속되는 고유 값. 회원은 여러개의 RefreshToken 을 가질 수 있음. <br> token 필드는 일회용으로, 재발급시마다 재생성함.
 */
@Entity
@Getter
@Table(name = "refresh_token", indexes = {
    @Index(name = "idx__refresh_token__token", columnList = "token")})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshTokenSpecific {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refreshTokenId;

    @Column(name = "token", columnDefinition = "BINARY(16)")
    private UUID token;

    @Column(name = "issued_to_id")
    private Long issuedToId;

    @Column(name = "issued_to_name")
    private String issuedToName;

    @Column(name = "issued_at")
    private LocalDateTime issuedAt;

    @Column(name = "renewed_at")
    private LocalDateTime renewedAt;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Builder
    protected RefreshTokenSpecific(
        Long refreshTokenId,
        UUID token,
        Long issuedToId,
        String issuedToName,
        LocalDateTime issuedAt,
        LocalDateTime renewedAt,
        LocalDateTime expiresAt
    ) {
        this.refreshTokenId = refreshTokenId;
        this.token = token;
        this.issuedToId = issuedToId;
        this.issuedToName = issuedToName;
        this.issuedAt = issuedAt;
        this.renewedAt = renewedAt;
        this.expiresAt = expiresAt;
    }

    static public RefreshTokenSpecific create(
        Long issuedTo,
        String issuedToName,
        long expirationInMinutes
    ) {
        LocalDateTime now = LocalDateTime.now();
        return RefreshTokenSpecific.builder()
                   .token(UUID.randomUUID())
                   .issuedToId(issuedTo)
                   .issuedToName(issuedToName)
                   .issuedAt(now)
                   .renewedAt(now)
                   .expiresAt(now.plusMinutes(expirationInMinutes))
                   .build();
    }

    private void checkExpiration() {
        if (this.expiresAt.isBefore(LocalDateTime.now())) {
            throw RefreshTokenExpirationException.INSTANCE;
        }
    }

    private void regenToken() {
        this.token = UUID.randomUUID();
    }

    public void renew(long expirationInMinutes, String username) {
        checkUsernameMatches(username);
        checkExpiration();
        renewedAt = LocalDateTime.now();
        expiresAt = renewedAt.plusMinutes(expirationInMinutes);
        regenToken();
    }

    private void checkUsernameMatches(String username) {
        if (!username.equals(this.issuedToName)) {
            throw new RefreshTokenRenewException("username mismatch");
        }
    }

    public String getTokenValue() {
        return token.toString();
    }

    public RefreshToken convert() {
        return RefreshToken.builder()
                   .refreshToken(this.getTokenValue())
                   .issuedToUsername(this.getIssuedToName())
                   .issuedToId(this.getIssuedToId())
                   .expiresAt(this.getExpiresAt())
                   .build();
    }
}
