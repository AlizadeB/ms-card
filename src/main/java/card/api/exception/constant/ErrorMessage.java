package card.api.exception.constant;

public interface ErrorMessage {
    String CARD_NOT_FOUND = "Account not found with given account number  {0}";
    String CUSTOMER_NOT_FOUND = "Account is not found {0}";
    String CARD_ALREADY_ACTIVE = "Card already active {0}" ;
    String CARD_ALREADY_DEACTIVE = "Card already deactive {0}" ;
    String CARD_ALREADY_CLOSED = "Card already closed {0}" ;
}
