package com.appspot.exgearscms.controller.admin.article;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.cool.util.Pager;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;

public class IndexController extends Controller {
    private ArticleService articleService = new ArticleService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {

        int page = 1;
        if (request.getAttribute("page") != null) {
            page = Integer.valueOf((String)request.getAttribute("page"));
        }

        Pager<Article> pager = articleService.getArticleListWithPager(
            page, 20, webUserService.getWebUser());

        requestScope("pager", pager);
        return forward("index.jsp");
    }
}
