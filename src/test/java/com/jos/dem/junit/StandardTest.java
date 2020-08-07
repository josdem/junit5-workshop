package com.jos.dem.junit;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StandardTest {

  private static final Logger log = Logger.getLogger(StandardTest.class.getName());

  @BeforeAll
  static void setup() {
    log.info("Before any test execution");
  }

  @BeforeEach
  void init() {
    log.info("Before each test execution");
  }

  @Test
  @DisplayName("succeed test case")
  void succeedingTest(TestInfo testInfo) {
    log.info(String.format("Running %s ...", testInfo.getDisplayName()));
    assertTrue(true, () -> "Always passing this test");
  }

  @AfterEach
  void finish() {
    log.info("After each test execution");
  }

  @AfterAll
  static void tearDown() {
    log.info("After all test execution");
  }
}
