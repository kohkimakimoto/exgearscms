<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="Google App Engine,CMS,クラウドCMS,Java" lang="ja" xml:lang="ja" />
<meta name="description" content="ExGearsCMSはGoogle App Engineで動作するクラウドCMSです。" lang="ja" xml:lang="ja" />
<link rel="stylesheet" href="/static/default/css/default.css" type="text/css" media="all" />
<script type="text/javascript" src="/static/default/js/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="/static/default/js/jquery-ui-1.8.7.custom.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/static/default/js/jquery.plugin.js"></script>
<script type="text/javascript" src="/static/default/js/global.js"></script>
<title>${param.title}</title>
<c:import url="/_ga.jsp" />
</head>
<body>
<div class="container">
  <div class="header-wrap"><div class="header">
    <div><a href="/"><img src="/static/default/images/common/logo.png" /></a></div>
    <p class="desc">- Google App Engineで動作するオープンソースのクラウドCMS -</p>
    <ul class="header-menu">
      <li>
        <a href="/">HOME</a>
      </li>
      <li>
        <a href="/kohkimakimoto/">開発者ブログ</a>
      </li>
      <li>
        <a href="/p/terms">利用規約</a>
      </li>
      <c:if test="${user.authenticated}" >
      <li>
        <a href="/admin/">管理</a>
      </li>
      </c:if>
      <li class="last"></li>
    </ul>
  </div></div>
  <div class="content-wrap"><div class="content">
    ${param.content}
    <div style="clear: both;"></div>
  </div></div>
</div>
<div class="footer-wrap"><div class="footer">
  <p>"ExGearsCMS" developed by kohki makimoto. Powered by Google App Engine for Java.</p>
  <p>"ExGearsCMS" is a open source software licensed "Apache License 2.0".</p>
  <p><a href="/p/terms">利用規約</a></p>
</div></div>
</body>
</html>
