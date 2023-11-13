package wanted.budgetmanagement.auth.jwt.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;
import wanted.budgetmanagement.auth.jwt.domain.AccessTokenGenerator;
import wanted.budgetmanagement.config.JwtProperties;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class AccessTokenGeneratorImpl implements AccessTokenGenerator {

    private final JwtProperties jwtProperties;
    private final JwtEncoder jwtEncoder;

    @Override
    public String generate(Long memberId, String username) {
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                                     .issuer(jwtProperties.getIssuer())
                                     .issuedAt(Instant.now())
                                     .expiresAt(
                                         Instant.now()
                                             .plusSeconds(jwtProperties.getAccessTokenLifespanInMinutes() * 60)
                                     )
                                     .subject(jwtProperties.getSubject())
                                     .claim("memberId", memberId.toString())
                                     .claim("username", username)
                                     .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
}
