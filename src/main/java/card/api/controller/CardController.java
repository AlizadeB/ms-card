package card.api.controller;

import card.api.model.dto.CardDto;
import card.api.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("cards/")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("{customerId}")
    public ResponseEntity<List<CardDto>> getActiveCardsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok().body(cardService.getActiveCardsByCustomerId(customerId));
    }

    @GetMapping("{iban}")
    public ResponseEntity<List<CardDto>> getCardByIban(@PathVariable String iban) {
        return ResponseEntity.ok().body(cardService.getCardByIban(iban));
    }

    @PutMapping("{cardId}/activate")
    public ResponseEntity<Void> activateCard(@PathVariable String cardId) {
        cardService.activateCard(cardId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{cardId}/deactivate")
    public ResponseEntity<Void> deactivateCard(@PathVariable String cardId) {
        cardService.deactivateCard(cardId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{cardId}/close")
    public ResponseEntity<Void> closeCard(@PathVariable String cardId) {
        cardService.closeCard(cardId);
        return ResponseEntity.noContent().build();
    }

}
