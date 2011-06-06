package com.appspot.exgearscms.controller.admin.widget.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.widget.TwitterWidgetService;
import com.appspot.exgearscms.service.widget.UserInfoWidgetService;

public class NewController extends Controller {
    private TwitterWidgetService twitterWidgetService = new TwitterWidgetService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        WebUser webUser = webUserService.getWebUser();

        if ("POST".equals(request.getMethod()) && twitterWidgetService.create(requestMap, webUser)) {
            return redirect("/admin/widget/");
        }

        return forward("new.jsp");
    }
}
