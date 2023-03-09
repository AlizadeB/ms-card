package card.api.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardCashbackDto {
    @NotNull
    private String cardId;
    private BigDecimal amount;
    private String currency;

}
