package com.appspot.exgearscms.service.widget;

import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.meta.widget.UserInfoWidgetMeta;
import com.appspot.exgearscms.model.Article;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.model.widget.UserInfoWidget;


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

        UserInfoWidget userInfoWidget = new UserInfoWidget();
        BeanUtil.copy(input, userInfoWidget);
        userInfoWidget.getWebUserRef().setModel(webUser);
        userInfoWidget.save();
        return true;
    }

}
