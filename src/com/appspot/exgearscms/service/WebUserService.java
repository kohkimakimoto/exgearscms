package com.appspot.exgearscms.service;

import java.util.List;
import java.util.Map;

import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.SortCriterion;
import org.slim3.util.BeanUtil;

import com.appspot.exgearscms.meta.WebUserMeta;
import com.appspot.exgearscms.model.WebUser;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public class WebUserService {

    WebUserMeta meta = WebUserMeta.get();

    public boolean register(WebUser webUser, Map<String, Object> input) {

        // Validate
        Validators validators = new Validators(input);
        validators.add("uid",
            validators.required("ユーザIDは必須です。"),
            validators.minlength(4, "ユーザIDは4文字以上100字以内で指定してください。"),
            validators.maxlength(100, "ユーザIDは4文字以上100字以内で指定してください。"),
            validators.regexp("^[a-zA-Z0-9][a-zA-Z0-9_]+", "半角英数とアンダースコアで指定してください。また先頭にアンダースコアは使えません。")
        );

        if (webUser.isAuthenticated()) {
            validators.getErrors().put("uid", "このGoogleアカウントはすでに登録されています。");
            return false;
        }


        if (!validators.validate()) {
            // Validate errors.
            return false;
        }

        // Save process
        BeanUtil.copy(input, webUser);
        webUser.setAuthenticated(true);
        webUser.setActive(true);
        Transaction tx = Datastore.beginTransaction();

        // unique check
        if (!Datastore.putUniqueValue("WebUserUniqueUid", webUser.getUid())) {
            validators.getErrors().put("uid", "このユーザIDをすでに登録されています。別なユーザIDを指定してください。");
            return false;
        }

        Datastore.put(webUser);
        tx.commit();
        return true;
    }

    public List<WebUser> getWebUserList(SortCriterion sort, int limit) {
        return (List<WebUser>)Datastore.query(meta).sort(sort).limit(limit).asList();
    }

    public List<WebUser> getWebUserList(int limit) {
        return getWebUserList(meta.key.desc, limit);
    }

    public WebUser getWebUser() {
        WebUser webUser = null;
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        if (user == null) {
            // It's annonymous user.
            webUser = new WebUser();
            webUser.setAuthenticated(false);
        } else {
            webUser = getWebUserByEmail(user.getEmail());
            if (webUser == null) {
                // It's annonymous user on google account logined.
                webUser = new WebUser();
                webUser.setAuthenticated(false);
                webUser.setEmail(user.getEmail());
                webUser.setGuser(user);
            }
        }
        return webUser;
    }

    public WebUser getWebUserByEmail(String email) {
        return Datastore.query(meta).filter(meta.email.equal(email)).asSingle();
    }

    public WebUser getWebUserByUid(String uid) {
        return Datastore.query(meta).filter(meta.uid.equal(uid)).asSingle();
    }

    public WebUser getWebUserById(Long id) {
        Key key = Datastore.createKey(WebUser.class, id);
        WebUser webUser= Datastore.get(WebUser.class, key);
        return webUser;
    }

    public WebUser getWebUserById(String id) {
        if (id == null) {
            return null;
        }
        return getWebUserById(Long.valueOf(id));
    }
}
