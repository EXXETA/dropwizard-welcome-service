package de.exxeta.health;

import com.codahale.metrics.health.HealthCheck;

public class SalutationHealthCheck extends HealthCheck {

  private static final int MIN_LENGTH = 2;
  private static final String REGEX_CAPITAL_LETTER = "^[A-Z][A-Za-z0-9]*";
  private final String salutation;

  public SalutationHealthCheck(String salutation) {
    this.salutation = salutation;
  }

  @Override
  protected Result check() throws Exception {
    if (salutation.length() < MIN_LENGTH) {
      return Result.unhealthy("Salutation is too short!");
    }

    if (!salutation.matches(REGEX_CAPITAL_LETTER)) {
      return Result.unhealthy("Salutation should start with a capital letter!");
    }

    return Result.healthy();
  }

}
