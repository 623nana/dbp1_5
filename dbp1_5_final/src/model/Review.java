package model;

public class Review {
	private String course_id;
	private String stuID;
	private int rating;
	private String evaluation;
	private String opinion;
	
	public Review() {}

	public Review(String course_id, String stuID, int rating, String evaluation, String opinion) {
		this.course_id = course_id;
		this.stuID = stuID;
		this.rating = rating;
		this.evaluation = evaluation;
		this.opinion = opinion;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
}