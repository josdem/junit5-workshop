package com.jos.dem.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LambdaAssertionTest {

  private Person person = new Person("josdem", "joseluis.delacruz@gmail.com");

  @Test
  @DisplayName("Should show how we can use lambdas in a test")
  public void shouldTestLambdaExpression() {
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

  
}