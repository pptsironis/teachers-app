package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dao.StudentDAOImpl;
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentServiceImpl;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

@WebServlet("/delete-student")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO);
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		
		// Validation
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
		
		try {
			
			studentServ.deleteStudent(studentDTO);
			request.setAttribute("deletedStudent", studentDTO);
			request.setAttribute("wasDeleted", true);
			request.getRequestDispatcher("/jsps/studentsmenu.jsp")
				.forward(request, response);
			
		}catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/stentsmenu.jsp")
				.forward(request, response);
		} catch (StudentNotFoundException e){
			request.setAttribute("studentNotFound", true);
			request.getRequestDispatcher("/jsps/studentsmenu.jsp")
				.forward(request, response);
		}
	}
}
