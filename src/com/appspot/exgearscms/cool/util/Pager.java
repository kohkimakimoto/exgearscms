package com.appspot.exgearscms.cool.util;

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
    
    private List<M> results;
    
    private Integer count;
    
    private Long pointer = 1L;
    
    private int pagingOperator = OPERATOR_GREATER_THAN;

    private AbstractAttributeMeta<?, ?> pagingAttributeMeta;

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

    public void setPointer(Long pointer) {
        this.pointer = pointer;
    }

    public Long getPointer() {
        return pointer;
    }

    public void setPagingOperator(int pagingOperator) {
        this.pagingOperator = pagingOperator;
    }

    public int getPagingOperator() {
        return pagingOperator;
    }

    public void setPagingAttributeMeta(AbstractAttributeMeta<?, ?> pagingAttributeMeta) {
        this.pagingAttributeMeta = pagingAttributeMeta;
    }

    public AbstractAttributeMeta<?, ?> getPagingAttributeMeta() {
        return pagingAttributeMeta;
    }
    
    public void init() {
        // Counting
        count = query.count();
        
        Key pointerKey = Datastore.createKey(modelClass, pointer);
        FilterCriterion criterion = null;
        if (pagingOperator == OPERATOR_GREATER_THAN) {
            criterion = new GreaterThanCriterion(pagingAttributeMeta, pointerKey);
        } else if (pagingOperator == OPERATOR_LESS_THAN) {
            criterion = new LessThanCriterion(pagingAttributeMeta, pointerKey);
        } else {
            criterion = new GreaterThanCriterion(pagingAttributeMeta, pointerKey);
        }
        
        // Get data.
        results = query.filter(criterion).limit(getMaxPerPage()).asList();
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
}
