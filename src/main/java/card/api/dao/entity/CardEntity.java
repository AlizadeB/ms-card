package card.api.dao.entity;

import card.api.model.enums.CardStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "customer_id")
    private Long customerId;

    @NotNull
    @Column(name = "card_id")
    private String cardId;

    @NotNull
    @Column(name = "iban")
    private String iban;

    @NotNull
    @Column(name = "status")
    private CardStatus status;

}
