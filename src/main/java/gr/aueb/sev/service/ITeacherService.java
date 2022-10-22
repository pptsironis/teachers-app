package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public interface ITeacherService {
	/**
	 * Inserts a {@link Teacher} based on the data carried by the P{@link TeacherDTO}
	 * 
	 * @param teacherDTO
	 * 			DTO object that contains the data. 
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertTeacher(TeacherDTO teacherDTO) throws SQLException;
	/**
	 * Deletes {@link Teacher} based on the data carried by the P{@link TeacherDTO}
	 * 
	 * @param teacherDTO
	 * 			DTO object that contains the data.
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws TeacherNotFoundException
	 * 			if the teacher is not found
	 * 			
	 */
	void deleteTeacher(TeacherDTO teacherDTO) throws SQLException, TeacherNotFoundException;
	/**
	 * Updates a {@link Teacher} based on the data carried by the P{@link TeacherDTO} of the new teacher
	 * 
	 * @param oldTeacherDTO
	 * 			DTO object that contains the old data.
	 * @param newTeacherDTO
	 * 			DTO object that contains the new data.
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws SQLException;
	/**
	 * Gets a list of {@link List} of {@link Teacher} based on their last names
	 * @param lastname 
	 * 			a string of object that contains the last name of the teachers we are looking for or part of it
	 * @return 
	 * 			{@link List} of {@link Teacher} found based on last name
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	List<Teacher> getTeachersByLastname(String lastname) throws SQLException;
	
	/**
	 * Returns a {@link Teacher} based on h@ id
	 * @param id
	 * 			the id of the teacher we are looking for
	 * @return
	 * 			the {@link Teacher} with the appropriate id or null if the teacher not found
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 * @throws TeacherNotFoundException
	 * 			if the teacher is not found
	 */
	Teacher getTeacherById(int id) throws SQLException, TeacherNotFoundException;

}
