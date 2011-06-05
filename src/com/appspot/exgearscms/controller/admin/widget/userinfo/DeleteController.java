package com.appspot.exgearscms.controller.admin.widget.userinfo;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.widget.UserInfoWidget;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.widget.UserInfoWidgetService;

public class DeleteController extends Controller {
    private UserInfoWidgetService userInfoWidgetService = new UserInfoWidgetService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        WebUser webUser = webUserService.getWebUser();

        UserInfoWidget userInfoWidget = userInfoWidgetService.getUserInfoWidgetById(request.getParameter("id"));

        if (userInfoWidget == null || !userInfoWidget.getWebUserRef().getKey().equals(webUser.getKey())) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        if ("POST".equals(request.getMethod())) {
            userInfoWidget.delete();
            return redirect("/admin/widget/");
        } else {
            return redirect("/admin/widget/");
        }
    }
}
