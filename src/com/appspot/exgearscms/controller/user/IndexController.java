package com.appspot.exgearscms.controller.user;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.WebUserService;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String uid = (String)request.getAttribute("uid");
        WebUserService webUserService = new WebUserService();
        WebUser webUser = webUserService.getWebUserByUid(uid);
        if (webUser == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        // Redirect to url finishing slash, if it is not finish slash.
        String uri = (String)request.getAttribute("location");
        if (uri.indexOf("/", 1) == -1) {
            return redirect(uri + "/");
        }

        requestScope("webUser", webUser);

        return forward("index.jsp");
    }
}
