package com.appspot.exgearscms.controller;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {

    }

    @Override
    public String route(HttpServletRequest request, String path) {

        // For smart user url.

        int uidLen; // first section length on url
        if((uidLen = path.indexOf("/", 1)) == -1) {
            uidLen = path.length();
        }
        uidLen--;

        if (!path.startsWith("/_")
                && !path.startsWith("/admin")
                && !path.equals("/")
                && uidLen >= 4) {
            addRouting("/{uid}", "/user/?uid={uid}");
            addRouting("/{uid}/", "/user/?uid={uid}");

            addRouting("/{uid}/article/{id}", "/article/show?uid={uid}&id={id}");

            addRouting("/{uid}/*path", "/{path}?uid={uid}");
        }

        addRouting("/p/{page}", "/p/page?page={page}");

        request.setAttribute("location", request.getRequestURI());
        return super.route(request, path);
    }



}
