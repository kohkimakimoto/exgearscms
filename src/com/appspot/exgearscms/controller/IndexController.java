package com.appspot.exgearscms.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class IndexController extends Controller {
    WebUserService webUserService = new WebUserService();
    ArticleService articleService = new ArticleService();

    @Override
    public Navigation run() throws Exception {
        UserService userService = UserServiceFactory.getUserService();
        requestScope("logoutUrl", userService.createLogoutURL("/"));
        requestScope("loginUrl", userService.createLoginURL("/"));

        List<WebUser> webUserList = webUserService.getWebUserList(10);
        List<Article> articleList = articleService.getArticleList(10);

        requestScope("webUserList", webUserList);
        requestScope("articleList", articleList);

        return forward("index.jsp");
    }
}
