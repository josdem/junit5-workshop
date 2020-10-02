package com.jos.dem.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.logging.Logger;

@TestMethodOrder(OrderAnnotation.class)
class ExecutionMethodOrderTest {

  private final Logger log = Logger.getLogger(ExecutionMethodOrderTest.class.getName());

  @Test
  @Order(1)
  @DisplayName("first test")
  void shouldExecuteFirst(TestInfo testInfo) {
    log.info(String.format("Executing %s ...", testInfo.getDisplayName()));
  }

  @Test
  @Order(2)
  @DisplayName("second test")
  void shouldExecuteSecond(TestInfo testInfo) {
    log.info(String.format("Executing %s ...", testInfo.getDisplayName()));
  }

  @Test
  @Order(3)
  @DisplayName("third test")
  void shouldExecuteThird(TestInfo testInfo) {
    log.info(String.format("Executing %s ...", testInfo.getDisplayName()));
  }
}
