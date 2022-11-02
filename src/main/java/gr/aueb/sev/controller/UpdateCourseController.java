package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImpl;
import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImpl;
import gr.aueb.sev.service.CourseServiceImpl;

/**
 * Servlet implementation class UpdateCourseController
 */
@WebServlet("/update-course")
public class UpdateCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO); //Wiring
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String description = request.getParameter("description").trim();
		int teacherId = Integer.parseInt(request.getParameter("teacherId").trim());
		
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(id);
		courseDTO.setDescription(description);
		courseDTO.setTeacherId(teacherId);
		
		request.setAttribute("course", courseDTO);
		listTeachers(request, response);
	}
	private void listTeachers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastname = "";
		
		try {
			List<Teacher> teachers = teacherServ.getTeachersByLastname(lastname);
			
			if (teachers.size() == 0) {
				request.setAttribute("teacherNotFound", true);
				request.getRequestDispatcher("/jsps/coursesupdate.jsp")
					.forward(request, response);
			}else {
				request.setAttribute("teachers", teachers);
				request.getRequestDispatcher("/jsps/courseupdate.jsp")
				.forward(request, response);
			}
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/coursesupdate.jsp")
				.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String description = request.getParameter("description").trim();
		int teacherId = Integer.parseInt(request.getParameter("teacherId").trim());
		
		CourseDTO oldCourseDTO = new CourseDTO();
		oldCourseDTO.setId(id);
		
		
		CourseDTO newCourseDTO = new CourseDTO();
		newCourseDTO.setDescription(description);
		newCourseDTO.setTeacherId(teacherId);
		
		try {
			courseServ.updateCourse(oldCourseDTO, newCourseDTO);
			request.setAttribute("updatedCourse", newCourseDTO);
			request.setAttribute("wasUpdated", true);
			request.getRequestDispatcher("/coursesmenu")
			.forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/coursesmenu")
				.forward(request, response);
		}
	}
}
