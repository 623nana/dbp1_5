package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Student;
import model.dao.StudentDAO;
import model.service.PasswordMismatchException;
import model.service.UserNotFoundException;

public class LoginController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);
	private StudentDAO studentDAO = new StudentDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("stuId");
		String password = request.getParameter("passwd");

		try {

			Student user = studentDAO.findUser(userId);

			if (user == null) {
				throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
			}

			if (!user.matchPassword(password)) {
				throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
			}

			HttpSession session = request.getSession();
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
			log.debug("로그인 성공");

			return "redirect:/";			
		} catch (Exception e) {
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			return "/service/loginForm.jsp";			
		}	
	}
}
