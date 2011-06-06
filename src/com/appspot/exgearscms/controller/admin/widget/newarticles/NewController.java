package com.appspot.exgearscms.controller.admin.widget.newarticles;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.widget.NewArticlesWidgetService;
import com.appspot.exgearscms.service.widget.UserInfoWidgetService;

public class NewController extends Controller {
    private NewArticlesWidgetService newArticlesWidgetService = new NewArticlesWidgetService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        WebUser webUser = webUserService.getWebUser();

        if ("POST".equals(request.getMethod()) && newArticlesWidgetService.create(requestMap, webUser)) {
            return redirect("/admin/widget/");
        }

        return forward("new.jsp");
    }
}
