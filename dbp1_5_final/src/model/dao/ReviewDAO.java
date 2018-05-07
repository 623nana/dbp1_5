package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

public class ReviewDAO {

	private JDBCUtil jdbcUtil = null;


	public ReviewDAO(){
		jdbcUtil = new JDBCUtil();
	}

	public int insertReview(Review review) throws SQLException{
		String sql = "INSERT INTO REVIEW VALUES (?, ?, ?, ?, ?)";
		Object[] param = new Object[] {review.getRating(),review.getEvaluation(), 
				review.getCourse_id(), review.getStuID(),review.getOpinion()};

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

	public int deleteReview(String stu_id, String course_id) throws SQLException {
		String sql = "DELETE FROM REVIEW WHERE stu_id = ? and course_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[]{stu_id, course_id});

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


	public List<Review> getReviewByCourseId(String course_id) throws SQLException {
		String sql = "SELECT * " + "FROM REVIEW WHERE course_id=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<Review> reviewList = new ArrayList<Review>();

			while(rs.next()) {
				Review review = new Review(
						course_id,
						rs.getString("stu_id"),
						rs.getInt("rating"),
						rs.getString("evaluation"),
						rs.getString("opinion"));
				reviewList.add(review);
			}
			return reviewList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public double getAvgRatingByCourseId (String course_id) throws SQLException {
		String sql = "select avg(rating) " + "from review where course_id = ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});
		double avg = 0;
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			while(rs.next()){
				avg = rs.getDouble(1);
			}
			return avg;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return avg;
	}

	public int getEvaluation1ByCourseId (String course_id) throws SQLException {

		String sql = "select count(*) " + "from review where course_id=? and evaluation = '1' ";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});
		int good = 0;
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if(rs.next()){
				good = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return good;
	}

	public int getEvaluation2ByCourseId (String course_id) throws SQLException {
		String sql = "select count(*) " + "from review where course_id=? and evaluation = '2' ";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});
		int soso = 0;
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if(rs.next()){
				soso = rs.getInt(1);
			}
			return soso;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return soso;
	}

	public int getEvaluation3ByCourseId (String course_id) throws SQLException {
		String sql = "select count(*) " + "from review where course_id=? and evaluation = '3' ";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});
		int bad = 0;
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			while(rs.next()){
				bad = rs.getInt(1);
			}
			return bad;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return bad;
	}

	public boolean existingReview(String stuID, String course_id) throws SQLException {
		String sql = "SELECT count(*) FROM REVIEW WHERE stu_id=? and course_id = ?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {stuID, course_id});

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
