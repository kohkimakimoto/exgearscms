package com.appspot.exgearscms.service.widget;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.meta.widget.NewArticlesWidgetMeta;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.widget.NewArticlesWidget;
import com.appspot.exgearscms.model.widget.UserInfoWidget;
import com.google.appengine.api.datastore.Key;


public class NewArticlesWidgetService {
    NewArticlesWidgetMeta meta = NewArticlesWidgetMeta.get();

    public boolean create(Map<String, Object> input, WebUser webUser) {
        Validators validators = new Validators(input);
        validators.add("dispOrder",
            validators.required("表示順は必須です。"),
            validators.integerType("表示順は数値で入力してください。"));
        validators.add("maxSize",
            validators.required("最大表示数は必須です。"),
            validators.integerType("最大表示数は数値で入力してください。"));
        if (!validators.validate()) {
            return false;
        }

        NewArticlesWidget widget = new NewArticlesWidget();
        BeanUtil.copy(input, widget);
        widget.getWebUserRef().setModel(webUser);
        widget.save();
        return true;
    }

    public boolean update(Map<String, Object> input, NewArticlesWidget widget, WebUser webUser) {
        Validators validators = new Validators(input);
        validators.add("dispOrder",
            validators.required("表示順は必須です。"),
            validators.integerType("表示順は数値で入力してください。"));
        validators.add("maxSize",
            validators.required("最大表示数は必須です。"),
            validators.integerType("最大表示数は数値で入力してください。"));
        if (!validators.validate()) {
            return false;
        }

        BeanUtil.copy(input, widget);
        widget.getWebUserRef().setModel(webUser);
        widget.save();
        return true;
    }

    public NewArticlesWidget getNewArticlesWidgetById(Long id) {
        Key key = Datastore.createKey(NewArticlesWidget.class, id);
        NewArticlesWidget widget = Datastore.get(NewArticlesWidget.class, key);
        return widget;
    }

    public NewArticlesWidget getNewArticlesWidgetById(String id) {
        if (id == null) {
            return null;
        }
        return getNewArticlesWidgetById(Long.valueOf(id));
    }

}
