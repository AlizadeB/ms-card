package card.api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(AllException.class)
    public CommonErrorResponse handleCardNotFoundException(AllException ex) {
        return new CommonErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(ALREADY_REPORTED)
    @ExceptionHandler(AllException.class)
    public CommonErrorResponse handleCardAlreadyActiveException(AllException ex) {
        return new CommonErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(ALREADY_REPORTED)
    @ExceptionHandler(AllException.class)
    public CommonErrorResponse handleCardAlreadyDeactiveException(AllException ex) {
        return new CommonErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(ALREADY_REPORTED)
    @ExceptionHandler(AllException.class)
    public CommonErrorResponse handleCardAlreadyClosedException(AllException ex) {
        return new CommonErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(AllException.class)
    public CommonErrorResponse handleCustomerNotFoundException(AllException ex) {
        return new CommonErrorResponse(ex.getErrorCode(), ex.getMessage());
    }
}
