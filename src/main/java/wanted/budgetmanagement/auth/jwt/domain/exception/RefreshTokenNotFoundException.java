package wanted.budgetmanagement.auth.jwt.domain.exception;

public class RefreshTokenNotFoundException extends RefreshTokenRenewException {

    static final public RefreshTokenNotFoundException INSTANCE = new RefreshTokenNotFoundException();
}
