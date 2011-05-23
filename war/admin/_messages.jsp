<%@page import="com.appspot.exgearscms.cool.util.*"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%
Messages messages = (Messages)request.getAttribute("system.messages");
if (messages != null && messages.size() > 0) {
    pageContext.setAttribute("messages", messages);
%>
<div class="messagebox"><div class="inner">
  <ul>
  <c:forEach var="message" items="${messages}">
    <li>${f:h(message)}</li>
  </c:forEach>
  </ul>
</div></div>
<%
}
%>