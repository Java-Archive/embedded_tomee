package junit.org.rapidpm.demo.embedded.tomee;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by svenruppert on 02.06.15.
 */
public class ServletTest {

  @BeforeClass
  public static void setUp() throws Exception {
    Map<String, String> properties = new HashMap<>();
    properties.put("httpejbd.print", "true");
    properties.put("httpejbd.indent.xml", "true");
    properties.put("openejb.embedded.remotable", "true");
    EJBContainer.createEJBContainer(properties);
  }



  //  private final String url = "http://127.0.0.1:4204/embedded_tomee/";
//  private final String url = "http://127.0.0.1:4204/embedded_tomee/MessageServlet/";
  private final String url = "http://127.0.0.1:4204/embedded_tomee/MessageServlet";
  //  private final String url = "http://127.0.0.1:8080/embedded_tomee/MessageServlet";
  private final String USER_AGENT = "Mozilla/5.0";

  @Test @Ignore
  public void testServletGetRequest() throws Exception {
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    // optional default is GET
    con.setRequestMethod("GET");
    //add request header
    con.setRequestProperty("User-Agent", USER_AGENT);

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'GET' request to URL : " + url);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuilder response = new StringBuilder();

    while ((inputLine = in.readLine()) != null) {
      System.out.println("inputLine = " + inputLine);
      response.append(inputLine);
    }
    in.close();

    //print result
    System.out.println("Response " + con.getResponseMessage());
    System.out.println("Response " + con.getContentType() );
    System.out.println("Response " + con.getContentLength() );
    System.out.println("Response " + con.getContentEncoding() );
    System.out.println("Response " + con.getContent() );

  }


}
