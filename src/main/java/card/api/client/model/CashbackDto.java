package card.api.client.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashbackDto {
    @NotNull
    private Long iban;
    private BigDecimal amount;
    private String currency;
}
