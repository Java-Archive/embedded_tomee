package junit.org.rapidpm.demo.embedded.tomee;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.rapidpm.demo.embedded.tomee.service.soap.PeopleWS;

import javax.ejb.embeddable.EJBContainer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
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
public class MyAppTest {

  @BeforeClass
  public static void setUp() throws Exception {
    Map<String, String> properties = new HashMap<>();
    properties.put("httpejbd.print", "true");
    properties.put("httpejbd.indent.xml", "true");
    properties.put("openejb.embedded.remotable", "true");
    EJBContainer.createEJBContainer(properties);

  }

  @Test
  public void test() throws Exception {
    Service service = Service.create(//dont forgett the module name -> embedded_tomee
        new URL("http://127.0.0.1:4204/embedded_tomee/PeopleWSImpl?wsdl"),
        new QName("http://rapidpm.org/wsdl", "PeopleWebService"));

    assertNotNull(service);


    final PeopleWS peopleWS = service.getPort(PeopleWS.class);
    Assert.assertEquals("doWork_A1000000", peopleWS.doWork_A());
  }

} 
