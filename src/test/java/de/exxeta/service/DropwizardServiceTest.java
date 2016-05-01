package de.exxeta.service;

import io.dropwizard.testing.junit.DropwizardClientRule;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

import de.exxeta.model.Greeting;
import de.exxeta.resource.WelcomeResource;

public class DropwizardServiceTest {

  private static final String SALUTATION = "Hello";

  private final Client client = ClientBuilder.newClient();

  @ClassRule
  public final static DropwizardClientRule dropwizard = new DropwizardClientRule(new WelcomeResource(SALUTATION));

  @Test
  public void testWelcomeResource() throws Exception {
    WebTarget target = client.target(dropwizard.baseUri()).path("welcome");
    Greeting response = target.request().get(Greeting.class);
    Assert.assertEquals(SALUTATION, response.getSalutation());
  }
}
