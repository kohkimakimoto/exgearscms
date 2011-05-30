package com.appspot.exgearscms.controller;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.cool.util.SiteContext;
import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.WebUserService;

public abstract class ApplicationController extends Controller {

    @Override
    protected Navigation setUp() {
        SiteContext siteContext = new SiteContext(request);
        requestScope("context", siteContext);
        return super.setUp();
    }

}
