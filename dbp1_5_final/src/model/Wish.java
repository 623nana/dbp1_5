package model;

public class Wish {

	private String stuID;
	private String courseID;
	private String classID;
	
	public Wish() { }
	
	public Wish(String stuID, String courseID, String classID){
		this.stuID = stuID;
		this.courseID = courseID;
		this.classID = classID;
	}
	
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	
}
