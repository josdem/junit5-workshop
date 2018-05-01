package com.jos.dem.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
  void succeedingTest() {
    log.info("Running succeddingTest");
    assertTrue(true, () -> "Always passing test");
  }

  @AfterEach
  void finish() {
    log.info("After each test execution");
  }

  @AfterAll
  static void tearDown() {
    log.info("After any test execution");
  }

}