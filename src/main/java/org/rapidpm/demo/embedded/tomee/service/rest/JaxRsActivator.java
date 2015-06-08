package org.rapidpm.demo.embedded.tomee.service.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sven on 27.05.15.
 */
@ApplicationPath("/base")
public class JaxRsActivator extends Application {



  @Override
  public Set<Class<?>> getClasses() {
    HashSet<Class<?>> classes = new HashSet<>();
    classes.add(PeopleResource.class);
    return classes;
  }
}