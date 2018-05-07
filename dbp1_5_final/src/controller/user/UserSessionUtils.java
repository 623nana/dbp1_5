package controller.user;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
	public static final String USER_SESSION_KEY = "student";

	public static String getUserFromSession(HttpSession session) {
		String userId = (String)session.getAttribute(USER_SESSION_KEY);
		return userId;
	}

	public static boolean isLogined(HttpSession session) {
		if (getUserFromSession(session) != null) {
			return true;
		}
		return false;
	}

}
