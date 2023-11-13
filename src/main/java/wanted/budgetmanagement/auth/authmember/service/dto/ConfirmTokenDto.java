package wanted.budgetmanagement.auth.authmember.service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class ConfirmTokenDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    static public class ConfirmTokenRequest {
        @NotEmpty
        private String username;
        @NotEmpty
        private String password;
        @NotEmpty
        private String token;

        public ConfirmTokenRequest(String username, String password, String token) {
            this.username = username;
            this.password = password;
            this.token = token;
        }
    }
}
