package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Wish;
import model.dao.WishDAO;
import model.service.ExistingCourseException;
import model.service.ExistingWishException;
import model.service.LimitedDeptException;

public class InsertWishController implements Controller {

	private WishDAO wishDAO = new WishDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    
		String stu_id = request.getParameter("stu_id");
		String course_id = request.getParameter("course_id");
		String class_id = request.getParameter("class_id");
		
		String stu_dept = request.getParameter("stuDept");
		String day1 = request.getParameter("day1");
		String day2 = request.getParameter("day2");
		int time1 = Integer.parseInt(request.getParameter("time1"));
    	int time2 = Integer.parseInt(request.getParameter("time2"));
		
		Wish wish = new Wish(stu_id, course_id, class_id);
		
		try{
			if(wishDAO.alreadyInsert(stu_id, course_id)==true){
				throw new ExistingCourseException("이미 담은 과목입니다!");
			}
			if(wishDAO.existingWish(stu_id, day1, day2, time1, time2)==true){
				throw new ExistingWishException("겹치는 시간의 과목이 있습니다!");
			}
			if(wishDAO.limitedDept(stu_dept, class_id)==true){
				throw new LimitedDeptException(stu_dept + "는 수강할 수 없습니다!");
			}
			wishDAO.insertWish(wish);
			request.setAttribute("InsertOk", true);
			return "/service/list.jsp";
		}
		catch(Exception e){
			request.setAttribute("InsertFailed", true);
			request.setAttribute("exception", e);
			return "/service/list.jsp";
		}
		

	}

}
