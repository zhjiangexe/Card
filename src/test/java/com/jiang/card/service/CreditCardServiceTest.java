package com.jiang.card.service;

import com.jiang.card.domain.entity.Card;
import com.jiang.card.domain.repository.CreditCardRepository;
import com.jiang.card.exception.ServiceException;
import com.jiang.card.vo.CardForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreditCardServiceTest {
  @InjectMocks
  private CreditCardService creditCardService;
  @Mock
  private CreditCardRepository repository;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void saveError() {
    when(repository.findById(any())).thenReturn(Optional.of(new Card()));

    assertThatThrownBy(() -> creditCardService.save(new CardForm()))
        .isInstanceOf(ServiceException.class)
        .hasMessage("error.code.credit.card.service001");
  }
}