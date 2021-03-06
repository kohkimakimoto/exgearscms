package com.appspot.exgearscms.service.widget;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.meta.widget.UserInfoWidgetMeta;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.widget.UserInfoWidget;
import com.google.appengine.api.datastore.Key;


public class UserInfoWidgetService {
    UserInfoWidgetMeta meta = UserInfoWidgetMeta.get();

    public boolean create(Map<String, Object> input, WebUser webUser) {
        Validators validators = new Validators(input);
        validators.add("dispOrder",
            validators.required("表示順は必須です。"),
            validators.integerType("表示順は数値で入力してください。"));
        if (!validators.validate()) {
            return false;
        }

        UserInfoWidget widget = new UserInfoWidget();
        BeanUtil.copy(input, widget);
        widget.getWebUserRef().setModel(webUser);
        widget.save();
        return true;
    }

    public boolean update(Map<String, Object> input, UserInfoWidget widget, WebUser webUser) {
        Validators validators = new Validators(input);
        validators.add("dispOrder",
            validators.required("表示順は必須です。"),
            validators.integerType("表示順は数値で入力してください。"));
        if (!validators.validate()) {
            return false;
        }

        BeanUtil.copy(input, widget);
        widget.getWebUserRef().setModel(webUser);
        widget.save();
        return true;
    }


    public UserInfoWidget getUserInfoWidgetById(Long id) {
        Key key = Datastore.createKey(UserInfoWidget.class, id);
        UserInfoWidget userInfoWidget = Datastore.get(UserInfoWidget.class, key);
        return userInfoWidget;
    }

    public UserInfoWidget getUserInfoWidgetById(String id) {
        if (id == null) {
            return null;
        }
        return getUserInfoWidgetById(Long.valueOf(id));
    }

}
