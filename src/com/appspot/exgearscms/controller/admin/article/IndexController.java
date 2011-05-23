package com.appspot.exgearscms.controller.admin.article;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;

public class IndexController extends Controller {
    private ArticleService articleService = new ArticleService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        requestScope("pager", articleService.getArticleListWithPager(1, 10, webUserService.getWebUser()));
        return forward("index.jsp");
    }
}
