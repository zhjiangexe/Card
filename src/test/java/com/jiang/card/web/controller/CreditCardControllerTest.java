package com.jiang.card.web.controller;

import com.jiang.card.domain.entity.Card;
import com.jiang.card.service.CreditCardService;
import com.jiang.card.vo.CardForm;
import com.jiang.card.web.advice.GlobalAdvice;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

class CreditCardControllerTest {
  private static final String CARD_NO = "4539108027394363";
  private static final String USER_NAME = "USER NAME";
  private static final BigDecimal LIMIT10 = BigDecimal.TEN;
  @InjectMocks
  private CreditCardController commentController;
  @Mock
  private CreditCardService creditCardService;

  @BeforeEach
  void before() {
    MockitoAnnotations.initMocks(this);
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(commentController)
        .setControllerAdvice(new GlobalAdvice())
        .build();
    RestAssuredMockMvc.mockMvc(mockMvc);
  }

  @Test
  void WHEN_valid_data_THEN_status201_and_get_balance() {
    CardForm cardForm = new CardForm();
    cardForm.setUserName(USER_NAME);
    cardForm.setCardNo(CARD_NO);
    cardForm.setLimit(BigDecimal.valueOf(100));
    when(creditCardService.save(cardForm)).thenReturn(new Card(USER_NAME, CARD_NO, BigDecimal.ZERO, LIMIT10));

    given()
        .contentType("application/json")
        .body(cardForm)

        .when()
        .post("/api/cards")

        .then()
        .statusCode(201)
        .body("data.balance", notNullValue());
  }

  @ParameterizedTest(name = "[{index}]{0}, {1}, {2}, wrong {3}")
  @CsvSource({
      "j, 4539108027394363, 10, userName", // shorter userName
      "jiang, 4539108027394364, 10, cardNo", // wrong cardNo
      "jiang, 4539108027394363, , limit" // no input limit
  })
  void WHEN_invalid_data_THEN_status400(String userName, String cardNo, BigDecimal limit, String expectErrorField) throws UnsupportedEncodingException {
    CardForm cardForm = new CardForm();
    cardForm.setUserName(userName);
    cardForm.setCardNo(cardNo);
    cardForm.setLimit(limit);

    given()
        .contentType("application/json")
        .body(cardForm)

        .when()
        .post("/api/cards")

        .then()
        .statusCode(HttpStatus.BAD_REQUEST.value())
        .body("error.errors[0].field", is(expectErrorField));
  }

  @Test
  void WHEN_query_THEN_status200() {
    when(creditCardService.findAll()).thenReturn(Arrays.asList(new Card(), new Card()));

    given()
        .contentType("application/json")

        .when()
        .get("/api/cards")

        .then()
        .statusCode(HttpStatus.OK.value())
        .body("data", hasSize(2));
  }
}
