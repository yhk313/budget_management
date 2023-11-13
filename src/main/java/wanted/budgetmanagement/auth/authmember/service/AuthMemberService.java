package wanted.budgetmanagement.auth.authmember.service;


import wanted.budgetmanagement.auth.authmember.service.dto.ConfirmTokenDto;
import wanted.budgetmanagement.auth.authmember.service.dto.PasswordAuth;
import wanted.budgetmanagement.auth.authmember.service.dto.RefreshTokenAuth;
import wanted.budgetmanagement.auth.jwt.domain.AuthToken;
import wanted.budgetmanagement.web.api.member.request.SignupMemberRequest;

public interface AuthMemberService {

    /**
     * 가입 요청. 가입 요청시 6자리의 랜덤 코드를 이메일로 발송. (이메일 발송 생략에 대해서 논의 필요)
     *
     * @param request 멤버 생성 요청 DTO
     * @return member id
     */
    Long join(SignupMemberRequest request);

    /**
     * 가입 승인
     *
     * @param request 토큰 승인 요청 DTO
     */
    void joinConfirm(ConfirmTokenDto.ConfirmTokenRequest request);

    /**
     * username and password authentication
     * @param passwordAuth
     * @return Jwt
     */
    AuthToken authenticate(PasswordAuth passwordAuth);

    /**
     * refresh token authentication
     * @param refreshTokenAuth
     * @return Jwt
     */
    AuthToken authenticate(RefreshTokenAuth refreshTokenAuth);

}
