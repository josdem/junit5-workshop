package com.jos.dem.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

class ParameterizedShowTest {

  private PalindromeEvaluator evaluator = new PalindromeEvaluator();
  private final Logger log = Logger.getLogger(ParameterizedShowTest.class.getName());

  @DisplayName("Allow string as parameters")
  @ParameterizedTest
  @ValueSource(strings = { "radar", "anitalavalatina" })
  void shouldAllowStringAsParamters(String word) {
    log.info("Running: Parameters as string");
    assertTrue(evaluator.isPalindrome(word));
  }

}
