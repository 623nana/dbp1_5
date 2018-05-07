package model;

import java.io.Serializable;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. STUDENT 테이블과 대응됨
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stuID;
	private String deptID;
	private String password;
	private String stuName;
	private String email;
	private String field1;
	private String field2;

	public Student() { }		// �⺻ ������

	public Student(String stuID, String deptID, String password, String stuName, String email, String field1, String field2) {
		this.stuID = stuID;
		this.deptID = deptID;
		this.password = password;
		this.stuName = stuName;
		this.email = email;
		this.field1 = field1;
		this.field2 = field2;
	}

	public void update(Student updateUser) {
		this.password = updateUser.password;
		this.stuName = updateUser.stuName;
		this.email = updateUser.email;
		this.field1 = updateUser.field1;
		this.field2 = updateUser.field2;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	public boolean isSameUser(String stuID) {
		return this.stuID.equals(stuID);
	}

	@Override
	public String toString() {
		return "User [stuID=" + stuID + ", password=" + password + ", stuName=" + stuName + ", email=" + email + "]";
	}	
}
