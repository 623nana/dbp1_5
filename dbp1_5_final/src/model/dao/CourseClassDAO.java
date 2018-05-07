package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CourseClass;


public class CourseClassDAO{

	private JDBCUtil jdbcUtil = null;

	public CourseClassDAO(){
		jdbcUtil = new JDBCUtil();
	}

	public List<CourseClass> getCourseByCourseId(String course_id) throws SQLException {
		String sql ="select course.course_id as course_id, course.title as title, "
				+ "class.class_id as class_id, class.field as field,"
				+ "class.year as year, class.prof_name as prof_name, "
				+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2, class.division as division "
				+ "from course, class "
				+ "where course.course_id = ? and course.course_id = class.course_id order by title, class_id";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});


		try{
			ResultSet rs = jdbcUtil.executeQuery();
			List<CourseClass> searchList = new ArrayList<CourseClass>();

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
				searchList.add(dto);

			}

			return searchList;

		} catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	public List<CourseClass> getCourseByClassId(String class_id) throws SQLException {
		String sql ="select course.course_id as course_id, course.title as title, "
				+ "class.class_id as class_id, class.field as field,"
				+ "class.year as year, class.prof_name as prof_name, "
				+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2, class.division as division "
				+ "from course, class "
				+ "where class.class_id = ? and course.course_id = class.course_id order by title, class_id";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {class_id});


		try{
			ResultSet rs = jdbcUtil.executeQuery();
			List<CourseClass> searchList = new ArrayList<CourseClass>();

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
				searchList.add(dto);

			}

			return searchList;

		} catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	public  List<CourseClass> getCourseByProfName(String prof_name) throws SQLException{
		String sql =  "select course.course_id as course_id, course.title as title, "
				+ "class.class_id as class_id, class.field as field,"
				+ "class.year as year, class.prof_name as prof_name, "
				+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2, class.division as division "
				+ "from course, class "
				+ "where course.course_id = class.course_id and prof_name = ? order by title, class_id";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {prof_name}) ;


		try{
			ResultSet rs = jdbcUtil.executeQuery();
			List<CourseClass> searchList = new ArrayList<CourseClass>();

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
				searchList.add(dto);

			}

			return searchList;

		} catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;

	}


	public  List<CourseClass> getCourseByTitle(String title) throws SQLException{
		String sql =  "select course.course_id as course_id, course.title as title, "
				+ "class.class_id as class_id, class.field as field,"
				+ "class.year as year, class.prof_name as prof_name, "
				+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2, class.division as division " 
				+ "from course, class "
				+ "where course.course_id = class.course_id and title = ? order by title, class_id ";


		jdbcUtil.setSqlAndParameters(sql, new Object[] {title});

		try{
			ResultSet rs = jdbcUtil.executeQuery();
			List<CourseClass> searchList = new ArrayList<CourseClass>();
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
				searchList.add(dto);

			}

			return searchList;

		} catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;

	}

	public List<CourseClass> getCourseByField(String field) throws SQLException{
		String sql = "select course.course_id as course_id, course.title as title, "
				+ "class.class_id as class_id, class.field as field,"
				+ "class.year as year, class.prof_name as prof_name, "
				+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2 ,class.division as division "
				+ "from course, class "
				+ "where course.course_id = class.course_id and field = ? order by title, class_id";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {field});


		try{
			ResultSet rs = jdbcUtil.executeQuery();
			List<CourseClass> searchList = new ArrayList<CourseClass>();

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
				searchList.add(dto);

			}
			return searchList;

		} catch(Exception ex){
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
			return null;
		}


		public List<CourseClass> getCourseByDay(String day1, String day2) throws SQLException{
			if(day2 == null){
				String sql = "select course.course_id as course_id, course.title as title, "
						+ "class.class_id as class_id, class.field as field,"
						+ "class.year as year, class.prof_name as prof_name, "
						+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2 ,class.division as division "
						+ "from course, class "
						+ "where course.course_id = class.course_id and (day1 = ? or day2 = ?) order by field, title, class_id";
				jdbcUtil.setSqlAndParameters(sql, new Object[] {day1, day1});
			}else{
				String sql = "select course.course_id as course_id, course.title as title, "
						+ "class.class_id as class_id, class.field as field,"
						+ "class.year as year, class.prof_name as prof_name, "
						+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2 ,class.division as division "
						+ "from course, class "
						+ "where course.course_id = class.course_id and (day1 = ? and day2 = ?) order by field, title, class_id";
				jdbcUtil.setSqlAndParameters(sql, new Object[] {day1, day2});
			}

			try{
				ResultSet rs = jdbcUtil.executeQuery();
				List<CourseClass> searchList = new ArrayList<CourseClass>();

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
					searchList.add(dto);

				}
				return searchList;

			} catch(Exception ex){
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return null;
		}

		public List<CourseClass> getCourseByTime(int time1, int time2) throws SQLException{
			if(time2 == 0){
				String sql = "select course.course_id as course_id, course.title as title, "
						+ "class.class_id as class_id, class.field as field,"
						+ "class.year as year, class.prof_name as prof_name, "
						+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2 ,class.division as division "
						+ "from course, class "
						+ "where course.course_id = class.course_id and (time1 = ? or time2 = ?) order by field, title, class_id";
				jdbcUtil.setSqlAndParameters(sql, new Object[] {time1, time1});
			}else{
				String sql = "select course.course_id as course_id, course.title as title, "
						+ "class.class_id as class_id, class.field as field,"
						+ "class.year as year, class.prof_name as prof_name, "
						+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2 ,class.division as division "
						+ "from course, class "
						+ "where course.course_id = class.course_id and (time1 = ? and time2 = ?) order by field, title, class_id";
				jdbcUtil.setSqlAndParameters(sql, new Object[] {time1, time2});
			}

			try{
				ResultSet rs = jdbcUtil.executeQuery();
				List<CourseClass> searchList = new ArrayList<CourseClass>();

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
					searchList.add(dto);

				}
				return searchList;

			} catch(Exception ex){
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return null;
		}

		public List<CourseClass> getSuggestByField(String field1, String field2) throws SQLException{
			String sql = "select course.course_id as course_id, course.title as title, "
					+ "class.class_id as class_id, class.field as field,"
					+ "class.year as year, class.prof_name as prof_name, "
					+"class.day1 as day1, class.day2 as day2, class.time1 as time1, class.time2 as time2 ,class.division as division "
					+ "from course, class "
					+ "where course.course_id = class.course_id and ( field = ? or field = ? ) order by field, title, class_id";
			jdbcUtil.setSqlAndParameters(sql, new Object[] {field1, field2});


			try{
				ResultSet rs = jdbcUtil.executeQuery();
				List<CourseClass> searchList = new ArrayList<CourseClass>();

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
					searchList.add(dto);

				}
				return searchList;

			} catch(Exception ex){
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return null;
		}


	}
