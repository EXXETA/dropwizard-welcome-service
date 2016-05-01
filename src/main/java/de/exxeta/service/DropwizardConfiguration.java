package de.exxeta.service;

import io.dropwizard.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

public class DropwizardConfiguration extends Configuration {

  @NotEmpty
  private String salutation;

  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

}
