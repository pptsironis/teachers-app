package gr.aueb.sev.dao;

import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.Student;

public class StudentDAOImpl implements IStudentDAO{

	@Override
	public void insert(Student student) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
			// + "'" + student.getFirstname() + "', " + "'" + student.getLastname() + "'"
			
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getFirstname());
			pst.setString(2, student.getLastname());
			
			pst.executeUpdate(); // we could add a variable as this returns the count of updates!!! (count of rows affected)
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
		
	}

	@Override
	public Student delete(Student student) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "DELETE FROM STUDENTS WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, student.getId());
			
			int n = pst.executeUpdate();
			
			if (n==0) {
				return null;
			}else {
				return student;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
		
	}

	@Override
	public void update(Student oldStudent, Student newStudent) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "UPDATE STUDENTS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, newStudent.getFirstname());
			pst.setString(2, newStudent.getLastname());
			pst.setInt(3, oldStudent.getId());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
		
	}

	@Override
	public List<Student> getStudentsByLastName(String lastname) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		List<Student> students = new ArrayList<>();
		ResultSet rs = null; // the ResultSet is used for reading the table returned b 
		
		try {
			String sql = "SELECT * FROM STUDENTS WHERE LASTNAME LIKE?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, lastname + "%");
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));
				
				students.add(student);
			}
			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}

	@Override
	public Student getStudentById(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		Student student = null;
		ResultSet rs = null; // the ResultSet is used for reading the table returned b 
		
		try {
			String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));
			}
			return student;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}

}
