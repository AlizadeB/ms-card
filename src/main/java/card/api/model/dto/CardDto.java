package card.api.model.dto;

import card.api.model.enums.CardStatus;
import card.api.model.enums.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CardDto {
    @NotNull
    private LocalDateTime createDate;
    private String iban;
    private BigDecimal balance;
    private Currency currency;
    private BigDecimal cashback;
    private CardStatus cardStatus;
}
