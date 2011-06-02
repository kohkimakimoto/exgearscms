package com.appspot.exgearscms.controller.admin.config;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.appspot.exgearscms.cool.util.Messages;
import com.appspot.exgearscms.model.Config;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.ConfigService;
import com.appspot.exgearscms.service.WebUserService;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return redirect("/admin/config/mypage");
    }
}
