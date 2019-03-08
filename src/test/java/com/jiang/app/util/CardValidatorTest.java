package com.jiang.app.util;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CardValidatorTest {

  @ParameterizedTest(name = "[{index}] app number: {0}, valid is {1}")
  @CsvSource({
      "4539108027394363, true",
      "5500542913424292, true",
      "340515615945553, true",
      "3589750422934391, true"
  })
  void WHEN_correct_number_THEN_return_true(String number, boolean expect) {

    boolean result = CardValidator.validateLuhn(number);

    assertThat(result).isEqualTo(expect);
  }

}
