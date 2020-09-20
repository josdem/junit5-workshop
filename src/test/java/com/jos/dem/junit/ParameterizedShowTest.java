package com.jos.dem.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParameterizedShowTest {

  private PalindromeEvaluator evaluator = new PalindromeEvaluator();
  private final Logger log = Logger.getLogger(ParameterizedShowTest.class.getName());

  @DisplayName("Allow string as parameters")
  @ParameterizedTest
  @ValueSource(strings = {"radar", "anitalavalatina"})
  void shouldAllowStringAsParameters(String word) {
    log.info("Running: Parameters as string");
    assertTrue(evaluator.isPalindrome(word));
  }

  @DisplayName("Allow enum as parameters")
  @ParameterizedTest
  @EnumSource(Environment.class)
  void shouldAllowEnumAsParameters(Environment environment) {
    assertNotNull(environment);
  }

  @DisplayName("Allow certain enum as parameters")
  @ParameterizedTest
  @EnumSource(
      value = Environment.class,
      names = {"DEVELOPMENT", "QA"})
  void shouldAllowCertainEnumAsParameters(Environment environment) {
    assertTrue(EnumSet.of(Environment.DEVELOPMENT, Environment.QA).contains(environment));
  }

  @DisplayName("Allow csv files as parameters")
  @ParameterizedTest
  @CsvFileSource(resources = "/csv/persons.txt", numLinesToSkip = 1)
  void shouldAllowCsvFileSource(int id, String nickname, String email) {
    assertNotNull(id);
    assertTrue(nickname.length() > 3);
    assertTrue(email.endsWith("email.com"));
  }

  @DisplayName("Allow json files as arguments")
  @ParameterizedTest
  @MethodSource("messages")
  void shouldBeValidMessages(String json){
    log.info("json: " + json);
  }

  private static Stream<Arguments> messages() {
    return Stream.of(
            Arguments.of("/json/sms.json"), Arguments.of("/json/pushNotification.json"));
  }

}
