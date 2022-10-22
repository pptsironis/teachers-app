package gr.aueb.sev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;
import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;

import gr.aueb.sev.model.Teacher;

public class TeacherDAOImpl implements ITeacherDAO {

	@Override
	public void insert(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
			// + "'" + teacher.getFirstname() + "', " + "'" + teacher.getLastname() + "'"
			
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, teacher.getFirstname());
			pst.setString(2, teacher.getLastname());
			
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
	public Teacher delete(Teacher teacher) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "DELETE FROM TEACHERS WHERE ID = ?";
			// + "'" + teacher.getFirstname() + "', " + "'" + teacher.getLastname() + "'"
			
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, teacher.getId());
			
			int n = pst.executeUpdate(); // we could add a variable as this returns the count of updates!!! (count of rows affected)
			
			if (n==0) {
				return null;
			}else {
				return teacher;
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
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		
		try {
			String sql = "UPDATE TEACHERS SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?";
			// + "'" + teacher.getFirstname() + "', " + "'" + teacher.getLastname() + "'"
			
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, newTeacher.getFirstname());
			pst.setString(2, newTeacher.getLastname());
			pst.setInt(3, oldTeacher.getId());
			
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
	public List<Teacher> getTeachersByLastName(String lastname) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		List<Teacher> teachers = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM TEACHERS WHERE LASTNAME LIKE ?";
			// + "'" + teacher.getFirstname() + "', " + "'" + teacher.getLastname() + "'"
			
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, lastname + "%");
			
			rs = pst.executeQuery(); // the executeQuery returns a result set
			
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("ID"));
				teacher.setFirstname(rs.getString("FIRSTNAME"));
				teacher.setLastname(rs.getString("LASTNAME"));
				
				teachers.add(teacher);
				
			}
			
			return teachers;
			//return (teachers.size() > 0) ? teachers : null;
						
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		Teacher teacher = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM TEACHERS WHERE ID = ?";
			// + "'" + teacher.getFirstname() + "', " + "'" + teacher.getLastname() + "'"
			
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			rs = pst.executeQuery(); // the executeQuery returns a result set
			
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt("ID"));
				teacher.setFirstname(rs.getString("FIRSTNAME"));
				teacher.setLastname(rs.getString("LASTNAME"));
			}
			
			return teacher;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (getConnection() != null) closeConnection();
		}
	}
}
