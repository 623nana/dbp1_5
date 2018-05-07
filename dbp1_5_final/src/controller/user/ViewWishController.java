package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CourseClass;
import model.dao.WishDAO;

public class ViewWishController implements Controller {
	
	private WishDAO wishDAO = new WishDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String stuId = request.getParameter("stuId");
		
		List<CourseClass> wishList = wishDAO.getWish(stuId);
		request.setAttribute("wishList", wishList);

		return "/service/wishlist.jsp";
	}
}
