package com.appspot.exgearscms.controller.article;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.controller.ApplicationController;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;

public class ShowController extends ApplicationController {
    WebUserService webUserService = new WebUserService();
    ArticleService articleService = new ArticleService();

    @Override
    public Navigation run() throws Exception {
        String uid = (String)request.getAttribute("uid");
        WebUser webUser = webUserService.getWebUserByUid(uid);
        if (webUser == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        String id = (String)request.getAttribute("id");
        Article article = articleService.getArticleById(id);
        if (article == null || !article.getWebUserRef().getKey().equals(webUser.getKey())) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        requestScope("webUser", webUser);
        requestScope("article", article);

        return forward("show.jsp");
    }
}
