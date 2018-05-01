package com.jos.dem.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertionShowTest {

  private Person person = new Person("josdem", "joseluis.delacruz@gmail.com");

  @Test
  @DisplayName("Should show how we can use lambdas in a test")
  void shouldTestLambdaExpression() {
    assertTrue(Stream.of(1, 2, 3)      
      .mapToInt(Integer::intValue)
      .sum() == 6, () -> "Sum should be 6");
  }

  @Test
  @DisplayName("Should assert all person attributes at once")
  void shouldAssertAllPersonAttributes() {
      assertAll("person",
          () -> assertEquals("josdem", person.getNickname()),
          () -> assertEquals("joseluis.delacruz@gmail.com", person.getEmail())
      );
  }

  @Test
  @DisplayName("Should show how works dependent assertions")
  void shouldTestDependentAssertions(){
    assertAll("person",
            () -> {
                String nickname = person.getNickname();
                assertNotNull(nickname);

                assertAll("nickname",
                    () -> assertTrue(nickname.startsWith("j")),
                    () -> assertTrue(nickname.endsWith("m"))
                );
            });
  }

  @Test
  @DisplayName("Should throw an exception")
  public void shouldThrowNullPointerException() {
    Person person = null;
    assertThrows(NullPointerException.class, ()-> person.getNickname());
  }

  @Test
  @Disabled("Should not execute this test")
  void shouldSkipThisTest() {
    assertTrue(false);
  }
  
}