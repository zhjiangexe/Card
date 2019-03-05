package com.jiang.card.web.controller;

import com.jiang.card.domain.entity.Card;
import com.jiang.card.dto.Resp;
import com.jiang.card.service.CreditCardService;
import com.jiang.card.vo.CardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CreditCardController {

  @Autowired
  private CreditCardService creditCardService;

  @PostMapping("/cards")
  public ResponseEntity<Resp> save(@RequestBody @Valid CardForm cardForm) {
    Card save = creditCardService.save(cardForm);
    return Resp.success(save, HttpStatus.CREATED);
  }

  @GetMapping("/cards")
  public ResponseEntity<Resp> findAll() {
    return Resp.success(creditCardService.findAll());
  }

}
