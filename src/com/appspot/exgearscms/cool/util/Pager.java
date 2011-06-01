package com.appspot.exgearscms.cool.util;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.AbstractAttributeMeta;
import org.slim3.datastore.CoreAttributeMeta;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.FilterCriterion;
import org.slim3.datastore.GreaterThanCriterion;
import org.slim3.datastore.LessThanCriterion;
import org.slim3.datastore.ModelMeta;
import org.slim3.datastore.ModelQuery;

import com.google.appengine.api.datastore.Key;

public class Pager<M> {

    public static final int OPERATOR_GREATER_THAN = 0;
    public static final int OPERATOR_LESS_THAN = 1;

    private Class<?> modelClass;

    private ModelQuery<M> query;

    private Integer maxPerPage;

    private Integer maxPageNumber = 10;

    private List<M> results;

    private Integer count = 0;

    private Integer page = 0;

    private Integer offset = 0;

    private Integer lastPage = 0;

    public void setModelClass(Class<?> modelClass) {
        this.modelClass = modelClass;
    }

    public Class<?> getModelClass() {
        return modelClass;
    }

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

    public void init() {
        // Counting
        count = query.count();

        if (count == 0 || page == 0 || maxPerPage == 0) {
            lastPage = 0;
        } else {
            offset = (page - 1) * maxPerPage;
            lastPage = (int)Math.ceil(count / maxPerPage);
        }

        // Get data.
        results = query.offset(offset).limit(maxPerPage).asList();
    }

    public List<Integer> getLinks() {
        List<Integer> links = new ArrayList<Integer>();
        int tmp = (int)(page - Math.floor(maxPageNumber / 2));
        int check = lastPage - maxPageNumber + 1;
        int limit = check > 0 ? check : 1;
        int begin = tmp > 0 ? (tmp > limit ? limit : tmp) : 1;

        int i = begin;
        while ((i < begin + maxPageNumber) && (i <= lastPage)) {
            links.add(i);
            i++;
        }

        links.add(i++);

        if (links.size() <= 1) {
            links = null;
        }

        return links;
    }

    public List<M> getResults() {
        return results;
    }

    public Integer getCount() {
        return count;
    }

    public Object getLast() {
        return results.get(results.size() -1);
    }

    public Object getFirst() {
        return results.get(0);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setMaxPageNumber(Integer maxPageNumber) {
        this.maxPageNumber = maxPageNumber;
    }

    public Integer getMaxPageNumber() {
        return maxPageNumber;
    }
}
