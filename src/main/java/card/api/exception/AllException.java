package card.api.exception;

import card.api.exception.constant.ErrorCode;

import java.text.MessageFormat;

public class AllException extends CommonException {
    public AllException(String message) {

        super(ErrorCode.CUSTOMER_NOT_FOUND, message);
    }

    public static AllException of(String message, Object... args) {
        return new AllException(MessageFormat.format(message, args));
    }
}
