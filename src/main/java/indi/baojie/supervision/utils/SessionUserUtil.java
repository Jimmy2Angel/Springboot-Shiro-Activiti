package indi.baojie.supervision.utils;

import indi.baojie.supervision.domain.User;

public class SessionUserUtil {

    public static void save(User user) {
        RequestUtil.getRequest().getSession().setAttribute("currentUser", user);
    }

    public static User current() {
        Object object = RequestUtil.getRequest().getSession().getAttribute("currentUser");
        if (object != null) {
            User user = (User) object;
            return user;
        }
        return null;
    }
}
