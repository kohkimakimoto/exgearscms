package com.appspot.exgearscms.cool.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Messages extends ArrayList<String>{

    private static final long serialVersionUID = 1L;

    /**
     * The request.
     */
    protected HttpServletRequest request;

    public Messages(HttpServletRequest request) {
        super();
        this.request = request;
        this.request.setAttribute("system.messages", this);
    }

}
