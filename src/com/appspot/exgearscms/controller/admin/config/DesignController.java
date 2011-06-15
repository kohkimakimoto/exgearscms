package com.appspot.exgearscms.controller.admin.config;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.constant.Env;

public class DesignController extends Controller {

    @Override
    public Navigation run() throws Exception {

        String[] designArray = Env.designArray;

        requestScope("designArray", designArray);
        return forward("design.jsp");
    }
}
