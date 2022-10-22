package gr.aueb.sev.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String eMail = request.getParameter("eMail").trim();
		String password = request.getParameter("password").trim();
		
		// Assume we call a login service
		if (eMail.equals("petran@gmail.com") && (password.equals("1234"))){
			request.getRequestDispatcher("/jsps/teachersmenu.jsp")
				.forward(request, response);
		} else {
			request.setAttribute("error", true);
			request.getRequestDispatcher("/jsps/login.jsp")
				.forward(request, response);
		}
	}
}
