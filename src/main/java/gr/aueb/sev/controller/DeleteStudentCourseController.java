package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.StudentCourseDAOImpl;
import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.service.StudentCourseServiceImpl;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;

/**
 * Servlet implementation class DeleteStudentCourseController
 */
@WebServlet("/delete-screlation")
public class DeleteStudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO);
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int studentId = Integer.parseInt(request.getParameter("studentId").trim());
		int courseId = Integer.parseInt(request.getParameter("courseId").trim());
		
		// Validation
		
		StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
		studentCourseDTO.setStudentId(studentId);
		studentCourseDTO.setCourseId(courseId);
		
		try {
			
			studentCourseServ.deleteStudentCourse(studentCourseDTO);
			
			request.setAttribute("studentCourse", studentCourseDTO);
			request.getRequestDispatcher("/student-courses")
				.forward(request, response);
			
		}catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/studentcourses.jsp")
				.forward(request, response);
		} catch (StudentCourseNotFoundException e){
			request.setAttribute("studentCourseNotFound", true);
			request.getRequestDispatcher("/jsps/studentCourses.jsp")
				.forward(request, response);
		}
	}

}
