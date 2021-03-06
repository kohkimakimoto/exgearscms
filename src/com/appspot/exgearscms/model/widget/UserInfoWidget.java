package com.appspot.exgearscms.model.widget;

import com.appspot.exgearscms.model.Widget;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class UserInfoWidget extends Widget {

    private static final long serialVersionUID = 1L;

    @Override
    public String getDisplayName() {
        return "ユーザ情報";
    }

    @Override
    public String getName() {
        return "userinfo";
    }

    @Override
    public String getDescription() {
        return "";
    }


}
