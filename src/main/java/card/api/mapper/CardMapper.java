package card.api.mapper;

import card.api.client.model.CashbackDto;
import card.api.dao.entity.CardEntity;
import card.api.model.dto.CardCashbackDto;
import card.api.model.dto.CardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardMapper CARD_MAPPER = Mappers.getMapper(CardMapper.class);

    List<CardDto> toCardDtoList(List<CardEntity> cards);

    @Mapping(target = "amount",source = "cashbackDto.amount")
    @Mapping(target = "currency",source = "cashbackDto.currency")
    CardCashbackDto toCardCashbackDto(CashbackDto cashbackDto, String cardId);
}
