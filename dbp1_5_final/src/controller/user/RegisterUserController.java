package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Student;
import model.dao.StudentDAO;
import model.service.ExistingUserException;

public class RegisterUserController implements Controller {

	private StudentDAO studentDAO = new StudentDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Student student = new Student(
				request.getParameter("stuId"),	
				request.getParameter("deptID"),
				request.getParameter("passwd"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("field1"),
				request.getParameter("field2"));
		try {

			if (studentDAO.existingUser(student.getStuID()) == true) {
				throw new ExistingUserException(student.getStuID() + "는 이미 등록된 학번입니다.");
			}
			studentDAO.create(student);
			request.setAttribute("registerOk", true);
			return "/";

		} catch (ExistingUserException e) {
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", student);
			return "/service/registerForm.jsp";
		}
	}
}
