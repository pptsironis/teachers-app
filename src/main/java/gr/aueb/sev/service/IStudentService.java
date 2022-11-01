package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

public interface IStudentService {
	/**
	 * Inserts a {@link Student} based on the data carried by the {@link StudentDTO}
	 * 
	 * @param studentDTO
	 * 			DTO object that contains the data. 
	 * @throws SQLException
	 * 			if any error happens during SQL transaction 
	 */
	void insertStudent(StudentDTO studentDTO) throws SQLException;
	/**
	 * Deletes {@link Student} based on the data carried by the {@link StudentDTO}
	 * 
	 * @param studentDTO
	 * 			DTO object that contains the data.
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 * @throws StudentNotFoundException
	 * 			if the student is not found
	 * 			
	 */
	void deleteStudent(StudentDTO studentDTO) throws SQLException, StudentNotFoundException;
	/**
	 * Updates a {@link Student} based on the data carried by the {@link StudentDTO} of the new student
	 * 
	 * @param oldStudentDTO
	 * 			DTO object that contains the old data.
	 * @param newStudentDTO
	 * 			DTO object that contains the new data.
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 */
	void updateStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO) throws SQLException;
	/**
	 * Gets a list of {@link List} of {@link Student} based on their last names
	 * @param lastname 
	 * 			a string of object that contains the last name of the teachers we are looking for or part of it
	 * @return 
	 * 			{@link List} of {@link Student} found based on last name
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 */
	List<Student> getStudentsByLastname(String lastname) throws SQLException;
	
	/**
	 * Returns a {@link Student} based on h@ id
	 * @param id
	 * 			the id of the student we are looking for
	 * @return
	 * 			the {@link Student} with the appropriate id or null if the student not found
	 * @throws SQLException
	 * 			if any error happens during SQL transaction
	 * @throws StudentNotFoundException
	 * 			if the teacher is not found
	 */
	Student getStudentById(int id) throws SQLException, StudentNotFoundException;

}
