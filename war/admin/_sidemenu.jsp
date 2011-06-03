<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%
String path = (String)request.getAttribute("location");
%>
<div class="sidemenu"><div class="inner">
<ul>
  <li class="root"><a class="<% if (path.equals("/admin/")) out.print("on");%>" href="/admin/">ダッシュボード</a></li>
  <li class="root"><a class="<% if (path.indexOf("/admin/article/") != -1) out.print("on");%>" href="/admin/article/">記事</a>
    <% if (path.indexOf("/admin/article/") != -1) { %>
    <ul class="child">
      <li><a class="<% if (path.equals("/admin/article/") || path.equals("/admin/article/edit")) out.print("on");%>" href="/admin/article/">記事</a></li>
      <li><a class="<% if (path.equals("/admin/article/new")) out.print("on");%>" href="/admin/article/new">新規作成</a></li>
    </ul>
    <% }%>
  </li>
<!--
  <li class="root"><a class="<% if (path.indexOf("/admin/page/") != -1) out.print("on");%>" href="/admin/page/">固定ページ</a>
    <% if (path.indexOf("/admin/page/") != -1) { %>
    <ul class="child">
      <li><a class="<% if (path.equals("/admin/page/")) out.print("on");%>" href="/admin/page/">固定ページ</a></li>
      <li><a class="<% if (path.equals("/admin/page/new")) out.print("on");%>" href="/admin/page/new">新規作成</a></li>
    </ul>
    <% }%>
  </li>
  <li class="root"><a class="<% if (path.indexOf("/admin/widget/") != -1) out.print("on");%>" href="/admin/widget/">ウィジェット</a>
    <% if (path.indexOf("/admin/widget/") != -1) { %>
    <ul class="child">
      <li><a class="<% if (path.equals("/admin/widget/")) out.print("on");%>" href="/admin/widget/">ウィジェット</a></li>
      <li><a class="<% if (path.equals("/admin/widget/new")) out.print("on");%>" href="/admin/widget/new">新規作成</a></li>
    </ul>
    <% }%>
  </li>
-->
  <li class="root"><a class="<% if (path.indexOf("/admin/config/") != -1) out.print("on");%>" href="/admin/config/">設定</a>
    <% if (path.indexOf("/admin/config/") != -1) { %>
    <ul class="child">
      <li><a class="<% if (path.equals("/admin/config/mypage")) out.print("on");%>" href="/admin/config/mypage">マイページ設定</a></li>
      <li><a class="<% if (path.equals("/admin/config/webuser")) out.print("on");%>" href="/admin/config/webuser">ユーザ設定</a></li>
    </ul>
    <% }%>
  </li>
  <li class="root"><a href="${user.logoutUrl}">ログアウト</a></li>
</ul>
</div></div>

