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
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.StudentCourseServiceImpl;

@WebServlet("/course-students")
public class SearchStudentsCourseControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String description = request.getParameter("description").trim();
		int teacherId = Integer.parseInt(request.getParameter("teacherId").trim());
		
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(id);
		courseDTO.setDescription(description);
		courseDTO.setTeacherId(teacherId);
		
		try {
			List<Student> courseStudents= studentCourseServ.getStudentsByCourses(id);
			List<Student> notCourseStudents= studentCourseServ.getStudentsNonRelatedToCourse(id);
			request.setAttribute("course", courseDTO);
			if (courseStudents.size() == 0) {
				request.setAttribute("studentCourseNotFound", true);
			}else {
				request.setAttribute("hasStudents", true);
				request.setAttribute("courseStudents", courseStudents);
			}
			if (notCourseStudents.size() == 0) {
				request.setAttribute("studentCourseNotFound", true);
			}else {
				request.setAttribute("hasTable", true);
				request.setAttribute("notCourseStudents", notCourseStudents);
			}
			request.getRequestDispatcher("/jsps/coursetudents.jsp")
			.forward(request, response);
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/coursetudents.jsp")
				.forward(request, response);
		}
	}
}