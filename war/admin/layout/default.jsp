<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/admin/static/css/admin-style.css" type="text/css" media="all" />
<script type="text/javascript" src="/admin//static/js/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="/admin//static/js/jquery-ui-1.8.7.custom.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/admin//static/js/jquery.plugin.js"></script>
<script type="text/javascript" src="/admin//static/js/global.js"></script>
<title>Administration tools</title>
</head>
<body class="body-admin">
<div class="container">

  <div class="header"><div class="inner">
    <a id="logo" href="/"><img src="/admin/static/images/common/admin_logo.png" /></a>
    <div class="menuleft">
      <a href="/admin/">管理</a>
      <a href="${user.url}">マイページ</a>
      <a href="${user.logoutUrl}">ログアウト</a>
    </div>
    <div class="menuright">
        <a class="uid" href="${user.url}">${user.uid}&nbsp;(${user.email})</a>
    </div>
    <div style="clear: both;"></div>
  </div></div>


  <div class="content"><div class="inner">
  ${param.content}
  <div style="clear: both;"></div>
  </div></div>

  <div class="footer"><div class="inner">
    <ul>
      <li>Powered by ExGearsCMS content management system.</li>
    </ul>
  </div></div>

</div>
</body>
</html>
