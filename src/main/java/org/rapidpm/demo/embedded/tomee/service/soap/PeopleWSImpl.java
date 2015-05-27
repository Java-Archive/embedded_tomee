package org.rapidpm.demo.embedded.tomee.service.soap;

import javax.ejb.Stateless;
import javax.jws.WebService;
import java.time.LocalDateTime;

/**
 * Created by sven on 22.05.15.
 */
@Stateless
@WebService(
    portName = "PeoplePort",
    serviceName = "PeopleWebService",
    targetNamespace = "http://rapidpm.org/wsdl",
    endpointInterface = "org.rapidpm.demo.embedded.tomee.service.soap.PeopleWS"
)
public class PeopleWSImpl implements PeopleWS{


  @Override
  public String doWork_A() {

    Byte[] bytes = new Byte[1_000_000];


    return "doWork_A" + bytes.length;
  }

  @Override
  public String doWork_B(String txt) {
    return txt + " worked on " + LocalDateTime.now().toString();
  }
}
