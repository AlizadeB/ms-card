package card.api.dao.repository;

import card.api.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    List<CardEntity> findByCustomerId(Long customerId);

    List<CardEntity> findCardsByIban(String iban);

    Optional<CardEntity> findCardByCardId(String cardId);
}
