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
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;

/**
 * Servlet implementation class SearchStudentCourseController
 */
@WebServlet("/coursesnotrelatedtostudent")
public class SearchCoursesNonRelatedToStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
		
		try {
			List<Course> studentCourses= studentCourseServ.getCoursesNonRelatedToStudent(id);
			request.setAttribute("student", studentDTO);
			if (studentCourses.size() == 0) {
				request.setAttribute("studentCourseNotFound", true);
				
				request.getRequestDispatcher("/jsps/studentcourses.jsp")
					.forward(request, response);
			}else {
				request.setAttribute("hasTable", true);
				request.setAttribute("studentCourses", studentCourses);
				request.getRequestDispatcher("/jsps/studentcourses.jsp")
					.forward(request, response);
			}
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/studentcourses.jsp")
				.forward(request, response);
		}
	}
}
