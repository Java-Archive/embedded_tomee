package org.rapidpm.demo.embedded.tomee;

import org.apache.openejb.testing.ApplicationComposers;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.rapidpm.demo.embedded.tomee.service.rest.PeopleResource;
import org.rapidpm.demo.embedded.tomee.service.soap.PeopleWSImpl;

/**
 * Created by sven on 22.05.15.
 */


@EnableServices(jaxws = true, jaxrs = true, httpDebug = false)
@Classes(context = "/", value = {PeopleResource.class, PeopleWSImpl.class})
public class MyApp {
  public static void main(final String[] args) {

    System.out.println("args = " + args);
    ApplicationComposers.run(MyApp.class, args);
  }
}
