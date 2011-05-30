package com.appspot.exgearscms.controller.reg;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.controller.ApplicationController;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.WebUserService;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class RegisterController extends ApplicationController {

    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {

        UserService userService = UserServiceFactory.getUserService();
        requestScope("logoutUrl", userService.createLogoutURL("/reg/register"));
        requestScope("loginUrl", userService.createLoginURL("/reg/register"));

        RequestMap requestMap = new RequestMap(request);
        WebUser webUser = webUserService.getWebUser();

        // POST process
        if ("POST".equals(request.getMethod()) && webUserService.register(webUser, requestMap)) {
            return redirect("/reg/complete");
        }
        return forward("register.jsp");
    }
}
