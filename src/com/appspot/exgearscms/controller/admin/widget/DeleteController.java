package com.appspot.exgearscms.controller.admin.widget;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.Widget;
import com.appspot.exgearscms.model.widget.UserInfoWidget;
import com.appspot.exgearscms.service.WebUserService;
import com.appspot.exgearscms.service.WidgetService;
import com.appspot.exgearscms.service.widget.UserInfoWidgetService;

public class DeleteController extends Controller {
    private WidgetService widgetService = new WidgetService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        WebUser webUser = webUserService.getWebUser();

        Widget widget = widgetService.getWidgetById(request.getParameter("id"));

        if (widget == null || !widget.getWebUserRef().getKey().equals(webUser.getKey())) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        if ("POST".equals(request.getMethod())) {
            widget.delete();
            return redirect("/admin/widget/");
        } else {
            return redirect("/admin/widget/");
        }
    }
}
