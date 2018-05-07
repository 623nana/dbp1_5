package model;

public class CourseClass {

	private String course_id = null;
	private String title = null;
	private String class_id=null;
	private String field=null;
	private int year;
	private String prof_name=null;
	private String day1=null;
	private String day2=null;
	private int time1;
	private int time2;
	private String division=null;

	public CourseClass(){}

	public CourseClass(String course_id, String title, String class_id, String field, int year, String prof_name,
			String day1, String day2, int time1, int time2, String division) 
	{
		this.course_id = course_id;
		this.title = title;
		this.class_id = class_id;
		this.field = field;
		this.year = year;
		this.prof_name = prof_name;
		this.day1 = day1;
		this.day2 = day2;
		this.time1 = time1;
		this.time2 = time2;
		this.division = division;
	}


	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}


	public String getProf_name() {
		return prof_name;
	}

	public void setProf_name(String prof_name) {
		this.prof_name = prof_name;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getDay2() {
		return day2;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTime1() {
		return time1;
	}

	public void setTime1(int time1) {
		this.time1 = time1;
	}

	public int getTime2() {
		return time2;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

}
