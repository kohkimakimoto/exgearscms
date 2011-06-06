package com.appspot.exgearscms.service.widget;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.meta.widget.NewArticlesWidgetMeta;
import com.appspot.exgearscms.meta.widget.TwitterWidgetMeta;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.widget.NewArticlesWidget;
import com.appspot.exgearscms.model.widget.TwitterWidget;
import com.google.appengine.api.datastore.Key;


public class TwitterWidgetService {
    TwitterWidgetMeta meta = TwitterWidgetMeta.get();

    public boolean create(Map<String, Object> input, WebUser webUser) {
        Validators validators = new Validators(input);
        validators.add("dispOrder",
            validators.required("表示順は必須です。"),
            validators.integerType("表示順は数値で入力してください。"));
        validators.add("account",
            validators.required("ツイッターアカウント名は必須です。"));
        if (!validators.validate()) {
            return false;
        }

        TwitterWidget widget = new TwitterWidget();
        BeanUtil.copy(input, widget);
        widget.getWebUserRef().setModel(webUser);
        widget.save();
        return true;
    }

    public boolean update(Map<String, Object> input, TwitterWidget widget, WebUser webUser) {
        Validators validators = new Validators(input);
        validators.add("dispOrder",
            validators.required("表示順は必須です。"),
            validators.integerType("表示順は数値で入力してください。"));
        validators.add("account",
            validators.required("ツイッターアカウント名は必須です。"));
        if (!validators.validate()) {
            return false;
        }

        BeanUtil.copy(input, widget);
        widget.getWebUserRef().setModel(webUser);
        widget.save();
        return true;
    }

    public TwitterWidget getTwitterWidgetById(Long id) {
        Key key = Datastore.createKey(TwitterWidget.class, id);
        TwitterWidget widget = Datastore.get(TwitterWidget.class, key);
        return widget;
    }

    public TwitterWidget getTwitterWidgetById(String id) {
        if (id == null) {
            return null;
        }
        return getTwitterWidgetById(Long.valueOf(id));
    }
}
