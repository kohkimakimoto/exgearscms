package com.appspot.exgearscms.service;

import java.util.List;
import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.cool.util.Pager;
import com.appspot.exgearscms.meta.ArticleMeta;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.google.appengine.api.datastore.Key;

public class ArticleService {

    ArticleMeta meta = ArticleMeta.get();

    public boolean post(Map<String, Object> input, WebUser webUser) {

        Validators validators = new Validators(input);

        if (!validators.validate()) {
            return false;
        }

        Article article = new Article();
        BeanUtil.copy(input, article);
        article.getWebUserRef().setModel(webUser);
        article.save();
        return true;
    }

    public boolean update(Map<String, Object> input, Article article, WebUser webUser) {
        Validators validators = new Validators(input);

        if (!validators.validate()) {
            return false;
        }

        BeanUtil.copy(input, article);
        article.getWebUserRef().setModel(webUser);
        article.save();
        return true;
    }

    public List<Article> getArticleList(int limit) {
        return Datastore.query(meta).sort(meta.key.desc).asList();
    }

    public List<Article> getArticleList(int limit, WebUser webUser) {
        return Datastore.query(meta).filter(meta.webUserRef.equal(webUser.getKey())).sort(meta.key.desc).asList();
    }

    public Pager<Article> getArticleListWithPager(int page, int maxPerPage) {
        Pager<Article> pager = new Pager<Article>();
        pager.setQuery(Datastore.query(meta).sort(meta.key.desc));
        pager.setPage(page);
        pager.setMaxPerPage(maxPerPage);
        pager.init();
        return pager;
    }

    public Pager<Article> getArticleListWithPager(int page, int maxPerPage, WebUser webUser) {
        Pager<Article> pager = new Pager<Article>();
        pager.setQuery(Datastore.query(meta).filter(meta.webUserRef.equal(webUser.getKey())).sort(meta.key.desc));
        pager.setPage(page);
        pager.setMaxPerPage(maxPerPage);
        pager.init();
        return pager;
    }

    public Article getArticleById(Long id) {
        Key key = Datastore.createKey(Article.class, id);
        Article article = Datastore.get(Article.class, key);
        return article;
    }

    public Article getArticleById(String id) {
        if (id == null) {
            return null;
        }
        return getArticleById(Long.valueOf(id));
    }

}
