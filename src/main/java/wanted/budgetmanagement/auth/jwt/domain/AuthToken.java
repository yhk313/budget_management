package wanted.budgetmanagement.auth.jwt.domain;

public record AuthToken(
    String accessToken,
    String refreshToken
) {

}
