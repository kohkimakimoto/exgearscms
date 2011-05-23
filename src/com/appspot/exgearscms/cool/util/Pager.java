package com.appspot.exgearscms.cool.util;

import java.util.List;

import org.slim3.datastore.ModelQuery;

public class Pager<M> {

    private ModelQuery<M> query;

    private Integer maxPerPage;

    private Integer page;

    public ModelQuery<M> getQuery() {
        return query;
    }

    public void setQuery(ModelQuery<M> query) {
        this.query = query;
    }

    public int getMaxPerPage() {
        return maxPerPage;
    }

    public void setMaxPerPage(Integer maxPerPage) {
        this.maxPerPage = maxPerPage;
    }


    public int getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void init() {

    }

    public List<M> getResults() {
        return query.asList();
    }

    public Integer getCount() {
        return query.count();
    }
}
