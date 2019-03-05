package com.jiang.card.vo;

import com.jiang.card.validator.CardNumber;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CardForm {
  @Length(min = 2, max = 256)
  private String userName;

  @Length(min = 12, max = 19)
  @CardNumber
  private String cardNo;

  @NotNull
  @DecimalMax(value = "99999999999999999")
  private BigDecimal limit;
}
