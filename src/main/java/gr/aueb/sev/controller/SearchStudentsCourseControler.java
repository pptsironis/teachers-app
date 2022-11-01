package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.StudentCourseDAOImpl;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;

/**
 * Servlet implementation class SearchStudentsCourseControler
 */
@WebServlet("/serach-sbcrelation")
public class SearchStudentsCourseControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int courseId = Integer.parseInt(request.getParameter("courseId").trim());
		
		try {
			List<Student> courseStudents= studentCourseServ.getStudentsByCourses(courseId);
			
			if (courseStudents.size() == 0) {
				request.setAttribute("studentCourseNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp")
					.forward(request, response);
			}else {
				request.setAttribute("courseStudents", courseStudents);
				request.getRequestDispatcher("/jsps/courseStudents.jsp")
					.forward(request, response);
			}
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
				.forward(request, response);
		}
	}
}