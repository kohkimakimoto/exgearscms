package com.appspot.exgearscms.controller.admin.widget;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class StatusController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return redirect("/admin/widget/");
    }
}
