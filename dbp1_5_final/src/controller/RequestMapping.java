package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.user.*;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		// 각 uri에 대응되는 controller 객체를 생성 및 저장
		mappings.put("/", new ForwardController("index.jsp"));
		mappings.put("", new ForwardController("index.jsp"));
		mappings.put("/service/login", new LoginController());
		mappings.put("/service/login/form", new ForwardController("/service/loginForm.jsp"));
		mappings.put("/service/logout", new LogoutController());
		mappings.put("/service/mypage", new MyPageController());
		mappings.put("/service/search", new ForwardController("/service/search.jsp"));
		mappings.put("/service/suggest", new SuggestController());
		mappings.put("/service/list", new SearchController());
		mappings.put("/service/course/view", new CourseViewController());
		mappings.put("/service/review/upload", new CreateReviewController());
		mappings.put("/service/review/delete", new DeleteReviewController());
		mappings.put("/service/register", new RegisterUserController());
		mappings.put("/service/register/form", new ForwardController("/service/registerForm.jsp"));
		mappings.put("/service/wish/insert", new InsertWishController());
		mappings.put("/service/wish/list", new ViewWishController());
		mappings.put("/service/wish/delete", new DeleteWishController());
		mappings.put("/service/wish/table", new TimeTableController());
		logger.info("Initialized Request Mapping!");
	}

	public Controller findController(String uri) {	
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}
