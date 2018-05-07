package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CourseClass;
import model.Wish;

public class WishDAO {

	private static JDBCUtil jdbcUtil = null;

	public WishDAO() {			
		jdbcUtil = new JDBCUtil();
	}
	
	public int insertWish(Wish wish) throws SQLException{
		String sql = "INSERT INTO WISHLIST VALUES (?, ?, ?)";
		Object[] param = new Object[] {wish.getStuID(), wish.getCourseID(), wish.getClassID()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try{
			int result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception e){
			jdbcUtil.rollback();
			e.printStackTrace();
		}finally{
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	
	public boolean existingWish(String stuId, String rDay1, String rDay2, int rTime1,int rTime2) throws SQLException {
		String sql = "select count(*) from wishlist, class " 
	+ "where wishlist.class_id = class.class_id and ((day1 = ? and time1 = ?) or (day1 = ? and time1 = ?) "
				+"or (day2 = ? and time2 = ?) or (day2 = ? and time2 = ?)) and stu_id = ?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {rDay1, rTime1, rDay2, rTime2 ,rDay1, rTime1, rDay2, rTime2, stuId});

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

	public boolean limitedDept(String deptName, String classId) throws SQLException {
		String sql = "select count(*) from class " 
				+"where limited_dept = ? and class_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {deptName, classId});

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

	public boolean alreadyInsert(String stuId, String courseId) throws SQLException {
		String sql = "select count(*) from wishlist " 
				+"where stu_id = ? and course_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {stuId, courseId});

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


	public List<CourseClass> getWish(String stuId) throws SQLException {
		String sql = "select a.course_id as course_id ,title, field, a.class_id as class_id , "
				+ "year, prof_name, day1, day2, time1, time2, division "
				+ "from wishlist, (select course.course_id as course_id, course.title as title, class.class_id as class_id,"
				+ "class.field as field, class.year as year, class.prof_name as prof_name, "
				+ "class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2, class.division as division "
				+ "from class, course where course.course_id = class.course_id) a "
				+ "where a.class_id = wishlist.class_id and stu_id = ? order by title, a.class_id ";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {stuId });

		try{
			ResultSet rs = jdbcUtil.executeQuery();
			List<CourseClass> wishList = new ArrayList<CourseClass>();

			while(rs.next()){
				CourseClass dto = new CourseClass(
						rs.getString("course_id"),
						rs.getString("title"),
						rs.getString("class_id"),
						rs.getString("field"),
						rs.getInt("year"),
						rs.getString("prof_name"),
						rs.getString("day1"),
						rs.getString("day2"),
						rs.getInt("time1"),
						rs.getInt("time2"),
						rs.getString("division"));
				wishList.add(dto);
			}

			return wishList;

		} catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}
	
	public String[][] timeTable(String stuId) throws SQLException {
		String sql = "select title, a.class_id as class_id , "
				+ " day1, day2, time1, time2 "
				+ "from wishlist, (select course.title as title, class.class_id as class_id,"
				+ "class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2 "
				+ "from class, course where course.course_id = class.course_id) a "
				+ "where a.class_id = wishlist.class_id and stu_id = ? order by title, a.class_id ";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {stuId });

		try{
			ResultSet rs = jdbcUtil.executeQuery();
			String[][] time = new String[6][5];
			int day1;
			int day2;
			
			while(rs.next()){
				day1 = Integer.parseInt(rs.getString("day1"));
				day2 = Integer.parseInt(rs.getString("day2"));
				
				time[(rs.getInt("time1")-1)][(day1-1)] = rs.getString("title");
				time[(rs.getInt("time2")-1)][(day2-1)] = rs.getString("title");	
			}
			return time;

		} catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}
	
	public int deleteWish(String stu_id, String class_id) throws SQLException {
		String sql = "DELETE FROM WISHLIST WHERE stu_id = ? and class_id = ? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[]{stu_id, class_id});

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

}
