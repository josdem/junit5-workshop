package com.jos.dem.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

class AssertionShowTest {

  private Person person = new Person("josdem", "joseluis.delacruz@gmail.com");

  @Test
  @DisplayName("Should show how we can use lambdas in a test")
  void shouldTestLambdaExpression() {
    assertTrue(Stream.of(1, 2, 3).mapToInt(Integer::intValue).sum() == 6, () -> "Sum should be 6");
  }

  @Test
  @DisplayName("Should assert all person attributes at once")
  void shouldAssertAllPersonAttributes() {
    assertAll(
        "person",
        () -> assertEquals("josdem", person.getNickname()),
        () -> assertEquals("joseluis.delacruz@gmail.com", person.getEmail()));
  }

  @Test
  @DisplayName("Should show how works dependent assertions")
  void shouldTestDependentAssertions() {
    assertAll(
        "person",
        () -> {
          String nickname = person.getNickname();
          assertNotNull(nickname, "Nickname should not be null");

          assertAll(
              "nickname",
              () -> assertTrue(nickname.startsWith("j"), "Should starts with j"),
              () -> assertTrue(nickname.endsWith("m"), "Should ends with m"));
        });
  }

  @Test
  @DisplayName("Should throw an exception")
  void shouldThrowNullPointerException() {
    Person person = null;
    assertThrows(NullPointerException.class, () -> person.getNickname());
  }

  @Test
  @Disabled("Should not execute this test")
  void shouldSkipThisTest() {
    assertTrue(false);
  }

  @Test
  @DisplayName("Should show how to run a test before timeout")
  void timeoutNotExceededWithMethod() {
    String actualGreeting = assertTimeout(ofMinutes(2), AssertionShowTest::greeting);
    assertEquals("Hello, World!", actualGreeting);
  }

  private static String greeting() {
    return "Hello, World!";
  }
}
