package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CourseClass;
import model.Review;
import model.dao.CourseClassDAO;
import model.dao.ReviewDAO;
import model.service.ExistingReviewException;

public class CreateReviewController implements Controller{

	private ReviewDAO reviewDAO = new ReviewDAO();
	private CourseClassDAO classCourseDAO = new CourseClassDAO();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String course_id = request.getParameter("course_id");
		String class_id = request.getParameter("class_id");
		int rating = Integer.parseInt(request.getParameter("rating"));

		Review review = new Review(
				request.getParameter("course_id"),
				request.getParameter("stu_id"),
				rating,
				request.getParameter("evaluation"),
				request.getParameter("opinion"));
		try {
			if (reviewDAO.existingReview(request.getParameter("stu_id"), course_id) == true) {
				throw new ExistingReviewException("이미 후기를 등록하셨습니다.");
			}
			reviewDAO.insertReview(review);
			
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

		} catch (ExistingReviewException e) {
			request.setAttribute("reviewFailed", true);
			request.setAttribute("exception", e);
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

}

