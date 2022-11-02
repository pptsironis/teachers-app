package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dao.StudentDAOImpl;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentServiceImpl;


@WebServlet("/search-student")
public class SearchStudentController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String lastname = request.getParameter("lastname").trim();
		
		try {
			List<Student> students= studentServ.getStudentsByLastname(lastname);
			
			if (students.size() == 0) {
				request.setAttribute("studentNotFound", true);
				request.getRequestDispatcher("/jsps/studentsmenu.jsp")
					.forward(request, response);
			}else {
				request.setAttribute("students", students);
				request.setAttribute("hasTable", true);
				request.getRequestDispatcher("/jsps/studentsmenu.jsp")
					.forward(request, response);
			}
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/studentsmenu.jsp")
				.forward(request, response);
		}
	}

}
