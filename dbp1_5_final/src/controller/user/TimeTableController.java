package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.WishDAO;

public class TimeTableController implements Controller {
	
	private WishDAO wishDAO = new WishDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String stuId = request.getParameter("stu_id");
		
		String[][] timeTable = new String[6][5];
		
		timeTable = wishDAO.timeTable(stuId);
		
		request.setAttribute("timeTable", timeTable);
		return "/service/timeTable.jsp";
	}
}
