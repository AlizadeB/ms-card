package card.api.exception;



import card.api.exception.constant.ErrorCode;

import java.text.MessageFormat;

public class NotFoundException extends CommonException {
    public NotFoundException(String message) {

        super(ErrorCode.CUSTOMER_NOT_FOUND, message);
    }

    public static NotFoundException of(String message, Object... args) {
        return new NotFoundException(MessageFormat.format(message, args));
    }
}
