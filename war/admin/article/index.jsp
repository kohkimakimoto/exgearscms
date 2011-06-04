<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="func" uri="/helper/functions"%>
<c:import url="/admin/layout/default.jsp">
<c:param name="title" value=""/>
<c:param name="content">
  <div class="content-left">
    <c:import url="/admin/_sidemenu.jsp" />
  </div>
  <div class="content-right">
    <h1 class="h1-content">記事</h1>
    <c:import url="/admin/_pager.jsp" >
      <c:param name="page" value="${page}"/>
    </c:import>
    <div class="content-table-wrapper">
    <table class="content-table stripe">
      <thead>
        <tr>
          <th>ID</th>
          <th>記事</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="var" items="${pager.results}">
        <tr>
          <td valign="top" class="first minrow">
            ${f:h(var.key.id)}
          </td>
          <td valign="top" class="">
            <div>${f:h(var.createdAt)}<a style="margin-left: 10px; font-size: 85%;" href="/admin/article/edit?id=${f:h(var.key.id)}">編集</a></div>
            <div style="padding: 0 0 10px 0;"><a style="color: #9999ff;" target="_blank" href="${f:h(var.url)}">${f:h(var.url)}</a></div>
            <div style="padding: 0 0 5px 0;">${f:h(var.title)}</div>
            <div style="font-size: 11px; color: #939393;">${f:h(var.text)}</div>
          </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
    <c:import url="/admin/_pager.jsp" >
      <c:param name="page" value="${page}"/>
    </c:import>
  </div>
</c:param>
</c:import>