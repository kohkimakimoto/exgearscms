<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<c:import url="/admin/layout/default.jsp">
<c:param name="title" value=""/>
<c:param name="content">
  <div class="content-left">
    <c:import url="/admin/_sidemenu.jsp" />
  </div>
  <div class="content-right">
    <div class="breadcrumb">
      <a href="/admin/">ダッシュボード</a>»
    </div>
    <h1 class="h1-content">ウィジェット</h1>
    <c:import url="/admin/_pager.jsp" >
      <c:param name="page" value="${page}"/>
    </c:import>
    <div class="content-table-wrapper">
    <table class="content-table stripe">
      <thead>
        <tr>
          <th>ID</th>
          <th>ウィジェット</th>
          <th>編集</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="var" items="${pager.results}">
        <tr>
          <td valign="top" class="first minrow">
            ${f:h(var.key.id)}
          </td>
          <td valign="top" class="minrow">
            <div>${f:h(var.createdAt)}</div>
            <div>${f:h(var.title)}</div>
          </td>
          <td valign="top" class="">
            <a target="_blank" href="${f:h(var.url)}">${f:h(var.url)}</a>
          </td>
          <td valign="top" class="minrow">
            <a href="/admin/article/edit?id=${f:h(var.key.id)}">編集</a>
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