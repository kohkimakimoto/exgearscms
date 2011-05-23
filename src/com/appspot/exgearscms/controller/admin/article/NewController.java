package com.appspot.exgearscms.controller.admin.article;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;

public class NewController extends Controller {
    private ArticleService articleService = new ArticleService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        WebUser webUser = webUserService.getWebUser();

        if ("POST".equals(request.getMethod()) && articleService.post(requestMap, webUser)) {

            return redirect("/admin/article/");
        }

        return forward("new.jsp");
    }
}
