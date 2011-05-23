package com.appspot.exgearscms.controller.admin.article;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ArticleService;
import com.appspot.exgearscms.service.WebUserService;

public class EditController extends Controller {
    private ArticleService articleService = new ArticleService();
    private WebUserService webUserService = new WebUserService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        WebUser webUser = webUserService.getWebUser();

        Article article = articleService.getArticleById(request.getParameter("id"));

        if (article == null || !article.getWebUserRef().getKey().equals(webUser.getKey())) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        if ("POST".equals(request.getMethod()) && articleService.update(requestMap, article, webUser)) {
            return redirect("/admin/article/");
        } else {
            BeanUtil.copy(article, requestMap);
        }

        requestScope("article", article);
        return forward("edit.jsp");
    }
}
