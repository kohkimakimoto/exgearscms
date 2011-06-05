<%@page import="com.appspot.exgearscms.model.Widget"%>
<%@page import="java.util.List"%>
<%@page import="com.appspot.exgearscms.model.WebUser"%>
<%@page import="com.appspot.exgearscms.cool.util.SiteContext"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%
SiteContext context = (SiteContext)request.getAttribute("context");
WebUser webUser = context.getUser();
List<Widget> widgetList = webUser.getWidgetList();
for (Widget wiget : widgetList) {
    String name = wiget.getName();
    pageContext.setAttribute("widgetJspURL", "/widgets/_" + name + ".jsp");
%>
<c:import url="${widgetJspURL}"></c:import>
<%}%>