package junit.org.rapidpm.demo.embedded.tomee;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.rapidpm.demo.embedded.tomee.service.soap.PeopleWS;

import javax.ejb.embeddable.EJBContainer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * MyApp Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Mai 22, 2015</pre>
 */
public class PeopleWSTest {

  @BeforeClass
  public static void setUp() throws Exception {
    Map<String, String> properties = new HashMap<>();
    properties.put("httpejbd.print", "true");
    properties.put("httpejbd.indent.xml", "true");
    properties.put("openejb.embedded.remotable", "true");
    EJBContainer.createEJBContainer(properties);
  }


  private String address = "http://127.0.0.1:4204/embedded_tomee/PeopleWSImpl";
  @Test @Ignore
  public void testSoap001() throws Exception {

    URL url = new URL(address + "?wsdl");
    final QName qName = new QName("http://rapidpm.org/wsdl", "PeopleWebService");
    Service service = Service.create(url, qName);
    assertNotNull(service);
    PeopleWS peopleWS = service.getPort(PeopleWS.class);
    assertNotNull(peopleWS);

    String reply = peopleWS.doWork_A();
    System.out.println("Server said: " + reply);
    org.junit.Assert.assertEquals("doWork_A1000000Service invoced", peopleWS.doWork_A());

  }



  @Test @Ignore
  public void testSoap() throws Exception {
    Service service = Service.create(//dont forget the module name -> embedded_tomee
        new URL("http://127.0.0.1:4204/PeopleWebService?wsdl"),
        new QName("http://rapidpm.org/wsdl", "PeopleWebService"));

    assertNotNull(service);
    final PeopleWS peopleWS = service.getPort(PeopleWS.class);
    Assert.assertEquals("doWork_A1000000Service invoced", peopleWS.doWork_A());
  }


  @Test @Ignore
  public void test() throws Exception {
    Service service = Service.create(//dont forgett the module name -> embedded_tomee
        new URL("http://127.0.0.1:4204/embedded_tomee/PeopleWSImpl?wsdl"),
        new QName("http://rapidpm.org/wsdl", "PeopleWebService"));

    assertNotNull(service);


    final PeopleWS peopleWS = service.getPort(PeopleWS.class);
    Assert.assertEquals("doWork_A1000000Service invoced", peopleWS.doWork_A());
  }







} 
