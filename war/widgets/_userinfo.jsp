<%@page import="com.appspot.exgearscms.model.Article"%>
<%@page import="java.util.List"%>
<%@page import="com.appspot.exgearscms.service.ArticleService"%>
<%@page import="com.appspot.exgearscms.model.WebUser"%>
<%@page import="com.appspot.exgearscms.cool.util.SiteContext"%>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%
SiteContext context = (SiteContext)request.getAttribute("context");
WebUser webUser = context.getUser();

ArticleService articleService = new ArticleService();
List<Article> articleList =  articleService.getArticleList(10, webUser);

pageContext.setAttribute("webUser", webUser);
%>
<div class="scbox1 user-info">
  <div class="inner">
    <div class="subject">ユーザ情報</div>
    <div>
      <img style="float: left; margin: 0 10px 10px 0;" src="${webUser.profileImageUrl}" />
      <a href="${webUser.url}">${webUser.uid}</a><br />
      <span style="color: #8e8e8e;">${f:h(webUser.webUserConfig.nickname)}</span>
      <div>
      <a href="/${f:h(context.user.uid)}/rss">RSS</a>(←作成中)
      </div>
    </div>
    <div style="clear: both;">
        ${f:h(webUser.webUserConfig.profile)}
    </div>
  </div>
</div>

