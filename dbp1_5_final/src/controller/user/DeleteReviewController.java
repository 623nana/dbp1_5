package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CourseClass;
import model.Review;
import model.dao.CourseClassDAO;
import model.dao.ReviewDAO;

public class DeleteReviewController implements Controller {

	private ReviewDAO reviewDAO = new ReviewDAO();
	private CourseClassDAO classCourseDAO = new CourseClassDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String course_id = request.getParameter("course_id");
		String stu_id = request.getParameter("stu_id");
		String class_id = request.getParameter("class_id");

		reviewDAO.deleteReview(stu_id, course_id);

		List<CourseClass> searchList = classCourseDAO.getCourseByClassId(class_id);
		List<Review> reviewList = reviewDAO.getReviewByCourseId(course_id);

		double avg = reviewDAO.getAvgRatingByCourseId(course_id);
		int good = reviewDAO.getEvaluation1ByCourseId(course_id);
		int soso = reviewDAO.getEvaluation2ByCourseId(course_id);
		int bad = reviewDAO.getEvaluation3ByCourseId(course_id);

		request.setAttribute("avg", avg);
		request.setAttribute("good", good);
		request.setAttribute("soso", soso);
		request.setAttribute("bad", bad);

		request.setAttribute("reviewList", reviewList);
		request.setAttribute("searchList", searchList);

		return "/service/view.jsp";
	}

}

