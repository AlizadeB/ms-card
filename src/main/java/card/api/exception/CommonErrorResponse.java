package card.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class CommonErrorResponse {
    private final String code;
    private final String message;
}
