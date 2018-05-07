package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CourseClass;
import model.dao.CourseClassDAO;

public class SuggestController implements Controller {
	private CourseClassDAO classCourseDAO = new CourseClassDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("UTF-8");
		String field1 = request.getParameter("field1");
		String field2 = request.getParameter("field2");

		List<CourseClass> searchList = classCourseDAO.getSuggestByField(field1, field2);
		request.setAttribute("searchList", searchList);

		return "/service/suggestList.jsp";
	}
}
