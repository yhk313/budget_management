package wanted.budgetmanagement.auth.authmember.service.dto;

public record RefreshTokenAuth(
    String username,
    String refreshToken
) {

}
