package com.jiang.app.util;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class CardValidator {
  public static boolean validateLuhn(String cardNo) {
    // when any single char is less than 48 or greater than 57(it's not 0 ~ 9), it's invalid, return false
    if (cardNo.length() < 12 || cardNo.length() > 19 || cardNo.chars().anyMatch(c -> c < 48 || c > 57)) {
      return false;
    }
    PrimitiveIterator.OfInt iterator = IntStream.iterate(
        (2 - cardNo.length() % 2), // initial by length if odd get 1 or even get 2
        i -> 3 - i
    ).iterator(); // 1, 2, 1, 2, 1 or 2, 1, 2, 1, 2
    int sum = cardNo.chars()
        .map(c -> c - '0') // convert char to the numeric(int)
        .map(n -> n * iterator.nextInt()) // multiply by 1 or 2
        .reduce(0, (a, b) -> a + b / 10 + b % 10);
    return sum % 10 == 0;
  }
}
