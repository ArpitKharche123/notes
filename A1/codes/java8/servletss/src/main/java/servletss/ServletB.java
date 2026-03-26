package servletss;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ServletB extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String enteredUsername = req.getParameter("name");
		String enteredPassword = req.getParameter("password");

		// Servlet Context
		// Can store commmon data for all the Servlets
		ServletContext context = req.getServletContext();

		String actualUsername = context.getInitParameter("user");
		String actualPassword = context.getInitParameter("password");

		if (enteredUsername.equals(actualUsername) 
			&& enteredPassword.equals(actualPassword)) {

			System.out.println("Login Successful");

			req.setAttribute("user", actualUsername);

			// RequestDispatcher
			RequestDispatcher dispatcher 
			= req.getRequestDispatcher("success");
			dispatcher.forward(req, resp);

		} else {
			resp.setContentType("text/html");
			resp.getWriter().print("<h1>Incorrect Credentials, try again: </h1>");

			RequestDispatcher dispatcher 
			= req.getRequestDispatcher("register.html");
			dispatcher.include(req, resp);

			// resp.sendRedirect("register.html");
		}
	}
}
