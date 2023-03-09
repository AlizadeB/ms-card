package card.api.service;

import card.api.client.CashbackClient;
import card.api.client.model.CashbackDto;
import card.api.dao.entity.CardEntity;
import card.api.dao.repository.CardRepository;
import card.api.exception.AllException;
import card.api.exception.constant.ErrorCode;
import card.api.mapper.CardMapper;
import card.api.model.dto.CardCashbackDto;
import card.api.model.dto.CardDto;
import card.api.model.enums.CardStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {

    private static final CardMapper mapper = CardMapper.CARD_MAPPER;

    private final CardRepository cardRepository;
    private final CashbackClient cashbackClient;

    public CardCashbackDto getCardCashback(String cardId) {
        CardEntity card = cardRepository.findCardByCardId(cardId).orElseThrow(
                () -> AllException.of(ErrorCode.CARD_NOT_FOUND, cardId)
        );
        CashbackDto cashbackDto = cashbackClient.getCashbackByIban(card.getIban());
        return mapper.toCardCashbackDto(cashbackDto, cardId);
    }

    public List<CardDto> getActiveCardsByCustomerId(Long customerId) {
        List<CardEntity> cards = cardRepository.findByCustomerId(customerId);
        List<CardEntity> activeCards = new ArrayList<>();

        cards.stream()
                .filter(card -> card.getStatus().equals(CardStatus.ACTIVE))
                .forEach(activeCards::add);

        return mapper.toCardDtoList(activeCards);
    }

    public List<CardDto> getCardByIban(String iban) {
        List<CardEntity> cards = cardRepository.findCardsByIban(iban);
        return mapper.toCardDtoList(cards);
    }

    private void updateCardStatus(CardEntity card, CardStatus newStatus) {
        switch (card.getStatus()) {
            case DEACTIVE -> updateCardStatusHelper(card, newStatus, CardStatus.ACTIVE);
            case ACTIVE -> updateCardStatusHelper(card, newStatus, CardStatus.DEACTIVE, CardStatus.CLOSE);
            case CLOSE -> throw AllException.of(ErrorCode.CARD_ALREADY_CLOSED);
        }
    }

    private void updateCardStatusHelper(CardEntity card, CardStatus newStatus, CardStatus... allowedStatuses) {
        Arrays.stream(allowedStatuses)
                .filter(status -> status == newStatus)
                .findFirst()
                .ifPresent(status -> {
                    card.setStatus(newStatus);
                    cardRepository.save(card);
                });
        if (card.getStatus() == CardStatus.ACTIVE) {
            throw AllException.of(ErrorCode.CARD_ALREADY_ACTIVE);
        } else {
            throw AllException.of(ErrorCode.CARD_ALREADY_DEACTIVE);
        }
    }

    public void activateCard(String cardId) {
        CardEntity card = cardRepository.findCardByCardId(cardId).orElseThrow(
                () -> AllException.of(ErrorCode.CARD_NOT_FOUND, cardId)
        );
        updateCardStatus(card, CardStatus.ACTIVE);
    }

    public void deactivateCard(String cardId) {
        CardEntity card = cardRepository.findCardByCardId(cardId).orElseThrow(
                () -> AllException.of(ErrorCode.CARD_NOT_FOUND, cardId)
        );
        updateCardStatus(card, CardStatus.DEACTIVE);
    }

    public void closeCard(String cardId) {
        CardEntity card = cardRepository.findCardByCardId(cardId).orElseThrow(
                () -> AllException.of(ErrorCode.CARD_NOT_FOUND, cardId)
        );
        updateCardStatus(card, CardStatus.CLOSE);
    }
}
