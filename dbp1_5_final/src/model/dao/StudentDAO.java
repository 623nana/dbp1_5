package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;

public class StudentDAO {

	private static JDBCUtil jdbcUtil = null;

	public StudentDAO() {			
		jdbcUtil = new JDBCUtil();
	}

	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */

	public int create(Student student) throws SQLException {
		String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {student.getStuID(), student.getDeptID(), 
				student.getStuName(), student.getEmail(), student.getPassword(),
				student.getField1(), student.getField2()};				
		jdbcUtil.setSqlAndParameters(sql, param);

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 諛섑솚
		}		
		return 0;			
	}
	
	public int update(Student student) throws SQLException {
		String sql = "UPDATE STUDENT "
					+ "SET password = ?, name = ?, email = ?, dept_name = ?, field1 = ?, field2 = ? "
					+ "WHERE stu_id = ?";
		Object[] param = new Object[] {student.getPassword(), student.getStuName(), 
					student.getEmail(), student.getDeptID(), student.getField1(),
					student.getField2(), student.getStuID()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	public Student findUser(String stuID) throws SQLException {
		String sql = "SELECT password, name, email, dept_name, field1, field2 "
				+ "FROM STUDENT WHERE stu_id = ? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {stuID});

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {
				Student student = new Student(
						stuID,
						rs.getString("dept_name"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("field1"),
						rs.getString("field2"));

				return student;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */

	public boolean existingUser(String stuID) throws SQLException {
		String sql = "SELECT count(*) FROM STUDENT WHERE stu_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {stuID});

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return false;
	}
	
	
}
