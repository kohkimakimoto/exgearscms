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
    <h1 class="h1-config">デザイン設定</h1>
    <div class="description">
      ページ全体のデザインを設定します。
    </div>
    <c:import url="/admin/_messages.jsp" />
    <div class="form-wrapper">
      <form action="/admin/config/webuser" method="post">
      <h2 class="section-title">設定</h2>
        <div style="float: left; width: 200px;">
        <ul style="border: 1px solid #eeeeee; padding: 10px; margin-bottom: 20px;">
          <li style="padding: 5px 0;">デザイン一覧</li>
          <c:forEach var="var" items="${designArray}">
            <li style="padding: 5px 0;"><a href="#">${f:h(var)}</a></li>
          </c:forEach>
        </ul>
        </div>
        <div style="clear: both;"></div>
      </form>
    </div>
  </div>
</c:param>
</c:import>