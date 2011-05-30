package com.appspot.exgearscms.cool.util;

import javax.servlet.http.HttpServletRequest;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.WebUserService;

public class SiteContext {

    private WebUser user = null;


    public SiteContext(HttpServletRequest request) {
        String uid = (String)request.getAttribute("uid");
        if (uid != null) {
            WebUserService webUserService = new WebUserService();
            user = webUserService.getWebUserByUid(uid);
        }
    }

    public WebUser getUser() {
        return user;
    }

    public void setUser(WebUser user) {
        this.user = user;
    }


}
