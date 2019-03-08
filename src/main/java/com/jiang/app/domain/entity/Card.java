package com.jiang.app.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "CARD")
public class Card implements Serializable {
  @Id
  private String cardNo;

  private String userName;

  private BigDecimal balance;

  @Column(name = "LIMIT_VALUE")
  private BigDecimal limit;

  public Card() {
  }

  public Card(String userName, String cardNo, BigDecimal balance, BigDecimal limit) {
    this.cardNo = cardNo;
    this.userName = userName;
    this.balance = balance;
    this.limit = limit;
  }

}
