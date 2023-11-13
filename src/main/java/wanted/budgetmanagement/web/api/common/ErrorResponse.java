package wanted.budgetmanagement.web.api.common;

import lombok.Getter;

@Getter
public class ErrorResponse<T> {
    private int statusCode;
    private T message;
    private String path;

    public ErrorResponse(int statusCode, T message, String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
    }
}
