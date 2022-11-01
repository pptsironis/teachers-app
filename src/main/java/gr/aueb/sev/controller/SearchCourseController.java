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
import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.CourseServiceImpl;

/**
 * Servlet implementation class SearchCourseController
 */
@WebServlet("/search-course")
public class SearchCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO); //Wiring
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String description = request.getParameter("description").trim();
		
		try {
			List<Course> courses= courseServ.getCoursesByDescription(description);
			
			if (courses.size() == 0) {
				request.setAttribute("courseNotFound", true);
				request.getRequestDispatcher("/jsps/menu.jsp")
					.forward(request, response);
			}else {
				request.setAttribute("courses", courses);
				request.getRequestDispatcher("/jsps/courses.jsp")
					.forward(request, response);
			}
			
		}catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/menu.jsp")
				.forward(request, response);
		}
	}

}
