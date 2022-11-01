package gr.aueb.sev.service.exceptions;

import gr.aueb.sev.model.StudentCourse;

public class StudentCourseNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public StudentCourseNotFoundException(StudentCourse studentCourse) {
		super("There is no relation between student with id = " + studentCourse.getStudentId() + " and course with id = " + studentCourse.getCourseId());
	}
}
