package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CourseClass;
import model.dao.CourseClassDAO;

public class SearchController implements Controller {

	private CourseClassDAO classCourseDAO = new CourseClassDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String searchType = request.getParameter("searchType");
		String searchText= request.getParameter("search");
		String[] day = request.getParameterValues("day");
		String[] time = request.getParameterValues("time");
		
		List<CourseClass> searchList;
		
	
		if(searchType.equals("1")){
			searchList = classCourseDAO.getCourseByTitle(searchText);
			request.setAttribute("searchList", searchList);
		}else if(searchType.equals("2")){
			searchList =classCourseDAO.getCourseByProfName(searchText);
			request.setAttribute("searchList", searchList);
		}else if(searchType.equals("3")){
			searchList =classCourseDAO.getCourseByCourseId(searchText);
			request.setAttribute("searchList", searchList);
		}else if(searchType.equals("4")){
			searchList =classCourseDAO.getCourseByField(searchText);
			request.setAttribute("searchList", searchList);
		}else if(searchType.equals("5")){
			if(day.length==1){
				searchList =classCourseDAO.getCourseByDay(day[0], null);
				request.setAttribute("searchList", searchList);
			}else{
				searchList =classCourseDAO.getCourseByDay(day[0], day[1]);
				request.setAttribute("searchList", searchList);
			}
		}else{
			if(time.length==1){
				int time1 = Integer.parseInt(time[0]);
				searchList =classCourseDAO.getCourseByTime(time1, 0);
				request.setAttribute("searchList", searchList);
			}else{
				int time1 = Integer.parseInt(time[0]);
				int time2 = Integer.parseInt(time[1]);
				searchList =classCourseDAO.getCourseByTime(time1, time2);
				request.setAttribute("searchList", searchList);
			}
		}
		if(searchList.size()==0){
			request.setAttribute("searchNull", true);
		}
		request.setAttribute("searchText", searchText);
		return "/service/list.jsp";
	}
}


