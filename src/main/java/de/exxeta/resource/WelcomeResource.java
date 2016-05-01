package de.exxeta.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import de.exxeta.model.Greeting;

@Path("/welcome")
@Produces(MediaType.APPLICATION_JSON)
public class WelcomeResource {

  private final String salutation;

  public WelcomeResource(String salutation) {
    this.salutation = salutation;

  }

  @GET
  @Timed
  public Greeting welcome() {
    return new Greeting(salutation);
  }
}
