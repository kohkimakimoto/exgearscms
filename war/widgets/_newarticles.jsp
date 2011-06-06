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

pageContext.setAttribute("articleList", articleList);

if (articleList.size() == 0) {
    return;
}
%>
<div class="scbox1 newarticles">
  <div class="inner">
    <div class="subject">新着記事</div>
    <ul>
    <c:forEach var="article" items="${articleList}"  begin="0"  end="${widget.maxSize - 1}">
      <li><a href="${f:h(article.url)}">${f:h(article.title)}</a></li>
    </c:forEach>
    </ul>
  </div>
</div>
