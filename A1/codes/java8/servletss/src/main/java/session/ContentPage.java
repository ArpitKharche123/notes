package session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/contentpage")
public class ContentPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();

		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");

		if (username != null) {
			printWriter.print("<h1>Welcome to Content Page </h1>");
		} else {
			printWriter.print("<h1>Please Login to view Content</h1>" 
		+ "<a href=\"login.html\">Login</a>");
		}

	}
}
