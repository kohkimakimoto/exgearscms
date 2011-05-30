package com.appspot.exgearscms.controller.reg;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.controller.ApplicationController;

public class CompleteController extends ApplicationController {

    @Override
    public Navigation run() throws Exception {
        return forward("complete.jsp");
    }
}
