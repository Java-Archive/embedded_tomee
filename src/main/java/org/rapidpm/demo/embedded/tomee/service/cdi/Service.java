package org.rapidpm.demo.embedded.tomee.service.cdi;

import javax.enterprise.inject.Default;
import java.time.LocalDateTime;

/**
 * Created by sven on 26.05.15.
 */
@Default
public class Service {

  public Service() {
    System.out.println("Service created = " + LocalDateTime.now().toString());
  }

  public String doWork(){ return "Service used";}

}
