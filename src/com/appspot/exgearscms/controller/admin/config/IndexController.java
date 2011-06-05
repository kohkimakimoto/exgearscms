package com.appspot.exgearscms.controller.admin.config;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;


public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return redirect("/admin/config/mypage");
    }
}
