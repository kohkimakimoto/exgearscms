package com.appspot.exgearscms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.router.RouterImpl;
import org.slim3.controller.router.Routing;

public class AppRouter extends RouterImpl {

    private static final Logger logger = Logger.getLogger(AppRouter.class.getName());
    
    protected List<Routing> routingToUserList = new ArrayList<Routing>();
    
    public AppRouter() {
        addRouting("/p/{page}", "/p/page?page={page}");
        
        addRoutingToUser("/{uid}", "/user/?uid={uid}");
        addRoutingToUser("/{uid}/", "/user/?uid={uid}");
        addRoutingToUser("/{uid}/article/{id}", "/article/show?uid={uid}&id={id}");
        addRoutingToUser("/{uid}/*path", "/{path}?uid={uid}");
    }

    @Override
    public String route(HttpServletRequest request, String path) {
        String rout;
        // set orignal uri
        request.setAttribute("location", request.getRequestURI());

        // For smart user url.
        int uidLen; // first section length on url
        if((uidLen = path.indexOf("/", 1)) == -1) {
            uidLen = path.length();
        }
        uidLen--;
        if (!path.startsWith("/_") && !path.startsWith("/admin") && !path.equals("/")  && uidLen >= 4) {
            // This pattern is a user url
            rout = routeToUser(request, path);
        } else {
            // Default routing
            rout = super.route(request, path);
        }
        
        return rout;
    }
    
    public String routeToUser(HttpServletRequest request, String path) {
        if (request == null) {
            throw new NullPointerException("The request parameter is null.");
        }
        if (path == null) {
            throw new NullPointerException("The path parameter is null.");
        }
        for (Routing r : routingToUserList) {
            String to = r.route(request, path);
            if (to != null) {
                return to;
            }
        }
        return null;
    }

    public void addRoutingToUser(String from, String to) throws NullPointerException {
        routingToUserList.add(new Routing(from, to));
    }
}
