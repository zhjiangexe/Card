package com.jiang.card.util;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CardValidatorTest {

  @ParameterizedTest(name = "[{index}] card number: {0}, valid is {1}")
  @CsvSource({
      "4539108027394363, true",
      "5500542913424292, true",
      "340515615945553, true",
      "3589750422934391, true"
  })
  void WHEN_one_of_the_numbers_is_not_a_numeric_THEN_return_false(String number, boolean expect) {

    boolean result = CardValidator.validateLuhn(number);

    assertThat(result).isEqualTo(expect);
  }

}
