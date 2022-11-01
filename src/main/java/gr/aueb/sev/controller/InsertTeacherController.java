package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImpl;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImpl;

@WebServlet("/insert-teacher")
public class InsertTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO); //Wiring

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setFirstname(firstname);
		teacherDTO.setLastname(lastname);
		
		try {
			teacherServ.insertTeacher(teacherDTO);
			request.setAttribute("insertedTeacher", teacherDTO);
			request.getRequestDispatcher("/jsps/teacherinserted.jsp")
				.forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/teachersmenu.jsp")
				.forward(request, response);
		}
	}
}
