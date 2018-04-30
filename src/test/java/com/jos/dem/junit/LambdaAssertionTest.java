package com.jos.dem.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class LambdaAssertionTest {

  @Test
  void shouldTestLambdaExpression() {
    assertTrue(Stream.of(1, 2, 3)      
      .mapToInt(Integer::intValue)
      .sum() == 6, () -> "Sum should be 6");
  }
  
}