package de.exxeta.service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import de.exxeta.health.SalutationHealthCheck;
import de.exxeta.resource.WelcomeResource;

public class DropwizardService extends Application<DropwizardConfiguration> {

  private static final String SERVICE_NAME = "Welcome";

  public static void main(String[] args) throws Exception {
    new DropwizardService().run(args);
  }

  @Override
  public String getName() {
    return SERVICE_NAME;
  }

  @Override
  public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
    // Environment initialization
  }

  @Override
  public void run(DropwizardConfiguration configuration, Environment environment) throws Exception {
    final WelcomeResource welcomeResource = new WelcomeResource(configuration.getSalutation());
    final SalutationHealthCheck salutationHealthCheck = new SalutationHealthCheck(configuration.getSalutation());

    environment.jersey().register(welcomeResource);
    environment.healthChecks().register("SalutationHealthCheck", salutationHealthCheck);
  }

}
