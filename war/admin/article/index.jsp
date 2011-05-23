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
    <h1 class="h1-content">記事</h1>
    <div class="content-table-wrapper">
    <table class="content-table stripe">
      <thead>
        <tr>
          <th>ID</th>
          <th>記事</th>
          <th>URL</th>
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
            ${f:h(var.title)}
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
  </div>
</c:param>
</c:import>