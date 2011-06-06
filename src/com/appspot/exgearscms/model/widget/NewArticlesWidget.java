package com.appspot.exgearscms.model.widget;


import com.appspot.exgearscms.model.Widget;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class NewArticlesWidget extends Widget {

    private static final long serialVersionUID = 1L;

    private int maxSize = 0;

    @Override
    public String getDisplayName() {
        return "新着記事";
    }

    @Override
    public String getName() {
        return "newarticles";
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }


}
