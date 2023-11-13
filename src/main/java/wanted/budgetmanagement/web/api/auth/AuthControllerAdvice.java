package wanted.budgetmanagement.web.api.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import wanted.budgetmanagement.auth.authmember.service.exception.AuthMemberNotFoundException;
import wanted.budgetmanagement.auth.authmember.service.exception.ConfirmNotFoundException;
import wanted.budgetmanagement.web.api.common.ErrorResponse;
import wanted.budgetmanagement.web.api.common.StatusCode;

@RestControllerAdvice
public class AuthControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AuthMemberNotFoundException.class)
    public ErrorResponse<String> handleMemberNotFoundException(AuthMemberNotFoundException e, HttpServletRequest request) {
        return new ErrorResponse<>(StatusCode.NOT_FOUND, e.getMessage(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ConfirmNotFoundException.class)
    public ErrorResponse<String> handleConfirmNotFoundException(ConfirmNotFoundException e, HttpServletRequest request) {
        return new ErrorResponse<>(StatusCode.NOT_FOUND, e.getMessage(), request.getRequestURI());
    }

    }
