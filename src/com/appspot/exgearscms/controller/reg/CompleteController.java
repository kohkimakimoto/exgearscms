package com.appspot.exgearscms.controller.reg;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class CompleteController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("complete.jsp");
    }
}
