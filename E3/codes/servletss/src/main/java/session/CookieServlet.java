package session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c1=new Cookie("name", "smith");
		Cookie c2=new Cookie("email", "smith@gmail.com");
		
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		System.out.println("Cookie created successfully");
	}
}
