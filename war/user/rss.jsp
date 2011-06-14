<?xml version="1.0" encoding="UTF-8"?>
<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page contentType="text/xml; charset=UTF-8" %>
<%@page import="com.appspot.exgearscms.constant.Env"%>
<rss version="2.0"
  xmlns:dc="http://purl.org/dc/elements/1.1/"
  xmlns:sy="http://purl.org/rss/1.0/modules/syndication/"
  xmlns:admin="http://webns.net/mvcb/"
  xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">

  <channel rdf:about="<%=Env.baseUrl%>/${f:h(context.user.uid)}/rss">
    <title>${f:h(context.user.uid)}のページ | ExGearsCMS</title>
    <link><%=Env.baseUrl%>/${f:h(context.user.uid)}</link>
    <description>${f:h(context.user.uid)}の投稿</description>
    <dc:language>ja</dc:language>
    <dc:creator>${f:h(context.user.uid)}</dc:creator>

    <items>
      <rdf:Seq>
      <c:forEach var="article" items="${articleList}" >
        <rdf:li rdf:resource="<%=Env.baseUrl%>${f:h(article.url)}"/>
      </c:forEach>
      </rdf:Seq>
    </items>
  </channel>

  <c:forEach var="article" items="${articleList}" >
  <item rdf:about="<%=Env.baseUrl%>${f:h(article.url)}">
    <title>${f:h(article.title)}</title>
    <link><%=Env.baseUrl%>${f:h(article.url)}</link>
  </item>
  </c:forEach>

</rss>