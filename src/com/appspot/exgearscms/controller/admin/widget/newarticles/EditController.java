package com.appspot.exgearscms.controller.admin.widget.newarticles;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.widget.NewArticlesWidget;
import com.appspot.exgearscms.model.widget.UserInfoWidget;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.widget.NewArticlesWidgetService;
import com.appspot.exgearscms.service.widget.UserInfoWidgetService;

public class EditController extends Controller {
    private NewArticlesWidgetService newArticlesWidgetService = new NewArticlesWidgetService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        WebUser webUser = webUserService.getWebUser();

        NewArticlesWidget widget = newArticlesWidgetService.getNewArticlesWidgetById(request.getParameter("id"));

        if (widget == null || !widget.getWebUserRef().getKey().equals(webUser.getKey())) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        if ("POST".equals(request.getMethod()) && newArticlesWidgetService.update(requestMap, widget, webUser)) {
            return redirect("/admin/widget/");
        } else {
            BeanUtil.copy(widget, requestMap);
        }

        requestScope("widget", widget);
        return forward("edit.jsp");
    }
}
