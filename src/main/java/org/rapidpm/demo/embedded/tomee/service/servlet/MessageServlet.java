package org.rapidpm.demo.embedded.tomee.service.servlet;


import javax.ejb.Stateless;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sven on 27.05.15.
 */
@Stateless
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {

  public MessageServlet() {
    System.out.println("MessageServlet = ");
  }

  //@Inject Service service;

  public static final String MESSAGE = "message";

  private String message;

  @Override
  public void init(final ServletConfig config) throws ServletException {
    super.init(config);
    message = config.getInitParameter(MESSAGE);
  }

  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.print("<html><body>");
    out.print("<h3>Hello Servlet</h3>");
    out.print("</body></html>");
    out.close();
  }

  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}