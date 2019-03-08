package com.jiang.app.service;

import com.jiang.app.domain.entity.Card;
import com.jiang.app.domain.repository.CreditCardRepository;
import com.jiang.app.exception.ServiceException;
import com.jiang.app.vo.CardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

  @Autowired
  private CreditCardRepository creditCardRepository;

  public Card save(CardForm cardForm) {
    String cardNumber = cardForm.getCardNo();
    Optional<Card> byId = creditCardRepository.findById(cardNumber);
    if (byId.isPresent()) {
      throw new ServiceException("error.code.credit.card.service001");
    }
    Card card = new Card();
    card.setCardNo(cardForm.getCardNo());
    card.setLimit(cardForm.getLimit());
    card.setUserName(cardForm.getUserName());
    card.setBalance(BigDecimal.ZERO);
    return creditCardRepository.save(card);
  }

  public List<Card> findAll() {
    return creditCardRepository.findAll();
  }
}
