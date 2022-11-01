package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentCourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

public interface IStudentCourseService {
	
	/**
	 * Inserts a new {@link StudentCourse} based on the data carried by the {@link StudentCourseDTO}
	 * 
	 * @param studentCourseDTO
	 * 			DTO object that contains the data
	 * @throws SQLException
	 * 			if any error happens during the SQL transaction
	 * @throws CourseNotFoundException
	 * 			if the teacher is not found
	 * @throws StudentNotFoundException
	 * 			if the student is not found
	 */
	void insertStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException;
	
	/**
	 * Deletes a {@link StudentCourse} based on the data carried by the {@link StudentCourseDTO}
	 * 
	 * @param studentCourseDTO
	 * 			DTO object that contains the data
	 * @throws SQLException
	 * 			if any error happens during the SQL transaction
	 * @throws StudentCourseNotFoundException
	 * 			if the connection between student and course was not found
	 */
	void deleteStudentCourse(StudentCourseDTO studentCourseDTO) throws SQLException, StudentCourseNotFoundException;
	
	/**
	 * Gets a {@link List} of {@link Course} based on a student id
	 * @param studentId
	 * 			the id of student we want the courses he participates in
	 * @return
	 * 			{@link List} of {@link Course} found based on student id
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 * @throws CourseNotFoundException
	 * 			if the course is not found
	 * @throws StudentNotFoundException
	 * 			if the Student is not found
	 */
	List<Course> getCoursesByStudent(int studentId) throws SQLException;
	
	/**
	 * Gets a {@link List} of {@link Student} based on a course id
	 * @param courseId
	 * 			the id of course we want the students that participate in it
	 * @return
	 * 			{@link List} of {@link Student} found based on course id
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 */
	List<Student> getStudentsByCourses(int courseId) throws SQLException;
}
