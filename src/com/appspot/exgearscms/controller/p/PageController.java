package com.appspot.exgearscms.controller.p;

import java.io.File;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.exgearscms.controller.ApplicationController;

public class PageController extends ApplicationController {

    @Override
    public Navigation run() throws Exception {

        String page = (String)request.getAttribute("page");

        File jspFile = new File(servletContext.getRealPath("/p/" + page + ".jsp"));
        if (!jspFile.exists()) {
            return redirect("/");
        }

        return forward(page + ".jsp");
    }
}
