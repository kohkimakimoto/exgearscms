package com.appspot.exgearscms.service;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.meta.widget.UserInfoWidgetMeta;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.Widget;
import com.appspot.exgearscms.model.widget.UserInfoWidget;
import com.google.appengine.api.datastore.Key;


public class WidgetService {

    public Widget getWidgetById(Long id) {
        Key key = Datastore.createKey(Widget.class, id);
        Widget widget = Datastore.get(Widget.class, key);
        return widget;
    }

    public Widget getWidgetById(String id) {
        if (id == null) {
            return null;
        }
        return getWidgetById(Long.valueOf(id));
    }

}
