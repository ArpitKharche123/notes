package session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class AuthServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		// Fetching login form fields 
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		
		// Fetching user and password from web.xml 
		ServletContext context = req.getServletContext();

		String actualUsername = context.getInitParameter("user");
		String actualPassword = context.getInitParameter("password");
		
		if (username.equals(actualUsername)
			&& password.equals(actualPassword)) {

			// Creating HttpSession Object
			//only when credentials match
			writer.print(
			"<h1>Login Success!!</h1>" 
			+"<a href=\"contentpage\">"
			+ "View Content</a>"
			+ "<br><br>"
			+ "<a href=\"logout\">Logout</a>");
			
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
		} else {
			writer.print("<h1>Login Failed!!</h1>" 
		+ "<a href=\"login.html\">Try Again</a>");
		}

	}
}
