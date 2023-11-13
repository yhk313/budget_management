package wanted.budgetmanagement.auth.jwt.domain;

import lombok.Builder;

import java.time.LocalDateTime;

public record RefreshToken(
    String refreshToken,
    Long issuedToId,
    String issuedToUsername,
    LocalDateTime expiresAt
) {
    @Builder
    public RefreshToken {
    }
}
