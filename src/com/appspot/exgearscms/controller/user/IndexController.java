package com.appspot.exgearscms.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.controller.ApplicationController;
import com.appspot.exgearscms.cool.util.Pager;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;

public class IndexController extends ApplicationController {

    private WebUserService webUserService = new WebUserService();
    private ArticleService articleService = new ArticleService();

    @Override
    public Navigation run() throws Exception {
        String uid = (String)request.getAttribute("uid");
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

        int page = 1;
        if (request.getAttribute("page") != null) {
            page = Integer.valueOf((String)request.getAttribute("page"));
        }

        Pager<Article> pager = articleService.getArticleListWithPager(
            page, 3, webUserService.getWebUser());
        requestScope("pager", pager);
        requestScope("webUser", webUser);

        return forward("index.jsp");
    }
}
