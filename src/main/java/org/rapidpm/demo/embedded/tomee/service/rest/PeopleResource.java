package org.rapidpm.demo.embedded.tomee.service.rest;

import org.rapidpm.demo.embedded.tomee.model.Person;
import org.rapidpm.demo.embedded.tomee.service.cdi.Service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by sven on 22.05.15.
 */
@Path("people")
@Produces(MediaType.APPLICATION_JSON)
public class PeopleResource {

  @Inject Service service;

  @GET
  @Path("master")
  public Person master() {
    return new Person("Christian - " + service.doWork());
  }

  @GET
  @Path("student")
  public Person student() {
    return new Person("Ana");
  }
}
