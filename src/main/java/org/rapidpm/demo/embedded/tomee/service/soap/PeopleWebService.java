package org.rapidpm.demo.embedded.tomee.service.soap;

import org.rapidpm.demo.embedded.tomee.service.cdi.Service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.time.LocalDateTime;

/**
 * Created by sven on 22.05.15.
 */
@WebService(
    portName = "PeoplePort",
    serviceName = "PeopleWebService",
    targetNamespace = "http://rapidpm.org/wsdl",
    endpointInterface = "org.rapidpm.demo.embedded.tomee.service.soap.PeopleWS"
)
@Stateless
public class PeopleWebService implements PeopleWS{


  @Inject Service service;

  @Override
  public String doWork_A() {
    Byte[] bytes = new Byte[1_000_000];
    return "doWork_A" + bytes.length + service.doWork();
  }

  @Override
  public String doWork_B(String txt) {
    return txt + " worked on " + LocalDateTime.now().toString();
  }
}
