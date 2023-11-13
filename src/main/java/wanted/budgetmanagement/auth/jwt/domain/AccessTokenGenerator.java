package wanted.budgetmanagement.auth.jwt.domain;

public interface AccessTokenGenerator {

    String generate(Long memberId, String username);
}
