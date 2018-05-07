package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Student;
import model.dao.StudentDAO;

public class MyPageController implements Controller {

	private StudentDAO studentDAO = new StudentDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(request.getMethod().equals("GET")){
			String userId = request.getParameter("stuId");
			Student student = studentDAO.findUser(userId);
			request.setAttribute("student",student);
			return "/service/myPage.jsp";
		}
		
		Student updateStudent = new Student(
				request.getParameter("stuId"),	
				request.getParameter("deptID"),
				request.getParameter("passwd"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("field1"),
				request.getParameter("field2"));
		
		studentDAO.update(updateStudent);
		HttpSession session = request.getSession();
		session.setAttribute(UserSessionUtils.USER_SESSION_KEY, updateStudent);
		return "redirect:/";
		
		
		

	}
}