<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.appspot.exgearscms.constant.Env"%>
<c:import url="/layout/default_user.jsp" >
<c:param name="title" value="${param.title}"/>
<c:param name="content" value="${param.content}"/>
</c:import>