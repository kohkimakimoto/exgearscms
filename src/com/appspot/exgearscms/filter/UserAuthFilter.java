package com.appspot.exgearscms.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.util.RequestUtil;

import com.appspot.exgearscms.model.WebUser;
import com.appspot.exgearscms.service.WebUserService;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class UserAuthFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;

        UserService userService = UserServiceFactory.getUserService();

        WebUserService webUserService = new WebUserService();
        WebUser webUser = webUserService.getWebUser();

        request.setAttribute("user", webUser);

        // Need authenticated to access this url.
        if (!webUser.isAuthenticated()) {
            String path = RequestUtil.getPath(request);

            if (path.indexOf("/admin/") == 0) {
                // Redirect google login page.
                response.sendRedirect(userService.createLoginURL(request.getRequestURI()));
                return;
            }
        }

        chain.doFilter(req, res);
    }

    public void init(FilterConfig arg0) throws ServletException {

    }




}