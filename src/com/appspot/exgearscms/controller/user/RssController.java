package com.appspot.exgearscms.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.controller.ApplicationController;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;

public class RssController extends ApplicationController {
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

        List<Article> articleList = articleService.getArticleList(30, webUser);

        requestScope("articleList", articleList);
        requestScope("webUser", webUser);

        return forward("rss.jsp");
    }
}
