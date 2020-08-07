package com.jos.dem.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssumptionShowTest {

  private final Logger log = Logger.getLogger(AssumptionShowTest.class.getName());
  private final Person person = new Person("josdem", "joseluis.delacruz@gmail.com");

  @Test
  @DisplayName("Assume that is a Gmail account")
  void shouldKnowIfIsGmailAccount() {
    assumeTrue(person.getEmail().endsWith("gmail.com"));
    log.info("Test continues ...");
    assertEquals("josdem", person.getNickname());
  }

  @Test
  @DisplayName("Assuming something based in conditions")
  void testAssumingThat() {
    assumingThat(2 > 1, () -> log.info("This should happen!"));
    assumingThat(2 < 1, () -> log.info("This should never happen!"));
  }
}
