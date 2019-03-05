package com.jiang.card.domain.repository;

import com.jiang.card.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CreditCardRepository extends JpaRepository<Card, String> {

}
