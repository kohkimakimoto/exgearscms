<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<div class="pager">
  <span class="count">${pager.count}件</span>
  <c:forEach var="page" items="${pager.links}">
     <c:if test="${page == pager.page}" >
        <span class="count">${page}</span>
     </c:if>
     <c:if test="${page != pager.page}" >
        <span class="count"><a href="${location}?page=${page}">${page}</a></span>
     </c:if>
  </c:forEach>
</div>


