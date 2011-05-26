package com.appspot.exgearscms.controller.admin;

import java.util.logging.Logger;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static final Logger logger = Logger.getLogger(IndexController.class.getName());
    
    @Override
    public Navigation run() throws Exception {
        logger.info("admin access.");
        
        return forward("index.jsp");
    }
}
