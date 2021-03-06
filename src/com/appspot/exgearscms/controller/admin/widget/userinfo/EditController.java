package com.appspot.exgearscms.controller.admin.widget.userinfo;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.widget.UserInfoWidget;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.widget.UserInfoWidgetService;

public class EditController extends Controller {
    private UserInfoWidgetService userInfoWidgetService = new UserInfoWidgetService();
    private WebUserService webUserService = new WebUserService();


    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        WebUser webUser = webUserService.getWebUser();

        UserInfoWidget widget = userInfoWidgetService.getUserInfoWidgetById(request.getParameter("id"));

        if (widget == null || !widget.getWebUserRef().getKey().equals(webUser.getKey())) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        if ("POST".equals(request.getMethod()) && userInfoWidgetService.update(requestMap, widget, webUser)) {
            return redirect("/admin/widget/");
        } else {
            BeanUtil.copy(widget, requestMap);
        }

        requestScope("widget", widget);
        return forward("edit.jsp");
    }
}
