package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello2 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest arg0, ServletResponse arg1)
      throws ServletException, IOException {
    System.out.println("Hello2---------------------------");

  }

}
