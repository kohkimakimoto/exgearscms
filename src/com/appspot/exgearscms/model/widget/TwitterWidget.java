package com.appspot.exgearscms.model.widget;

import java.io.Serializable;

import com.appspot.exgearscms.model.Widget;
import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class TwitterWidget extends Widget {

    private static final long serialVersionUID = 1L;

    private String account;

    @Override
    public String getDisplayName() {
        return "ツイッターWidget";
    }

    @Override
    public String getName() {
        return "twitter";
    }

    @Override
    public String getDescription() {
        return "Twitterアカウント " + account + " で設定";
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }


}
