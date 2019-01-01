package com.jos.dem.junit;

import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.util.logging.Logger;

class ConditionsShowTest {

  private final Logger log = Logger.getLogger(ConditionsShowTest.class.getName());

  @Test
  @DisplayName("Should run if DEV environment")
  @EnabledIfSystemProperty(named = "environment", matches = "DEV")
  void shouldRunIfDevelopmentEnvironment(){
    log.info("Running: Conditions if is development");
    assertTrue(true);
  }

  @Test
  @DisplayName("Should run if Monday")
  @EnabledIf("(java.time.LocalDate).now().getDayOfWeek() == 'MONDAY'")
  void shouldRunIfMonday() {
    log.info("Running: Conditions if is Monday");
    assertTrue(true);
  }

  @Test
  @EnabledOnOs({ LINUX, MAC })
  void shouldRunOnLinuxOrMac() {
    log.info("Running: Conditions if Linux or Mac");
    assertTrue(true);
  }

}
