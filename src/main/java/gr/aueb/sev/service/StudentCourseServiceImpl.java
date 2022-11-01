package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;

public class StudentCourseServiceImpl implements IStudentCourseService{
	private final IStudentCourseDAO studentCourseDAO;
	
	public StudentCourseServiceImpl(IStudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	@Override
	public void insertStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException{
		StudentCourse studentCourse = extract(studentCourseDTO);
		try {
			studentCourseDAO.insert(studentCourse);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void deleteStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException, StudentCourseNotFoundException {
		StudentCourse studentCourseToDelete = extract(studentCourseDTO);
		try {
			if(studentCourseDAO.delete(studentCourseToDelete)==null) {
				throw new StudentCourseNotFoundException(studentCourseToDelete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Course> getCoursesByStudent(int studentId) throws SQLException {
		try {
			return studentCourseDAO.getCoursesByStudent(studentId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Student> getStudentsByCourses(int courseId) throws SQLException {
		try {
			return studentCourseDAO.getStudentsByCourse(courseId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private StudentCourse extract(StudentCourseDTO studentCourseDTO) {
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setCourseId(studentCourseDTO.getCourseId());
		studentCourse.setStudentId(studentCourseDTO.getStudentId());
		return studentCourse;
	}
}
