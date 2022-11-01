package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;

public interface ICourseService {
	/**
	 * Insert a {@link Course} based on the data carried by the {@link CourseDTO}
	 * 
	 * @param courseDTO
	 * 			DTO object that contains the data
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 */
	void insertCourse(CourseDTO courseDTO) throws SQLException;
	/**
	 * Deletes a {@link Course} based on the data carried by the {@link CourseDTO}
	 * @param courseDTO
	 * 			DTO object that contains the data
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 * @throws CourseNotFoundException
	 * 			if the course is not found
	 */
	void deleteCourse(CourseDTO courseDTO) throws SQLException, CourseNotFoundException;
	/**
	 * Updates a {@link Course} based on the data carried by the {@link CourseDTO} of the new course
	 * 
	 * @param oldCourseDTO
	 * 			DTO object that contains the old data
	 * @param newCourseDTO
	 * 			DTO object that contains the new data
	 * @throws SQLException
	 * 			if any error happens during the SQL transaction
	 */
	void updateCourse(CourseDTO oldCourseDTO, CourseDTO newCourseDTO) throws SQLException;
	/**
	 * Gets a list {@link List} of {@link Course} based on their description
	 * @param description
	 * 			a string of object that contains the description of the course we are looking for or part of it 
	 * @return
	 * 			{@link List} of {@link Course} found base on description
	 * @throws SQLException
	 * 			if any error happens during the SQL exception
	 */
	List<Course> getCoursesByDescription(String description) throws SQLException;
	/**
	 * Returns a {@link Course} based on a id
	 * @param id
	 * 			the id of the course we are looking for
	 * @return
	 * 			the {@link Course} with the appropriate id or null if the course not found
	 * @throws SQLException
	 * 			if any error happens during the SQL exception
	 * @throws CourseNotFoundException
	 * 			if the course is not found
	 */
	Course getCourseById(int id) throws SQLException, CourseNotFoundException;
}
