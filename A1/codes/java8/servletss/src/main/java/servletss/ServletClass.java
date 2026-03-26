package servletss;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/test")
public class ServletClass extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.getWriter().print(
		"<h1>We are learning Servlets</h1>");
	}
}
