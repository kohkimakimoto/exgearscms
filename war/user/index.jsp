<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="func" uri="/helper/functions"%>
<c:import url="/layout/default.jsp">
<c:param name="title" value="${f:h(webUser.myPageConfig.title)} - (${f:h(webUser.webUserConfig.nickname)}さんのページ) | EXGearsCMS"/>
<c:param name="content" >
  <div class="content-top">
    <div class="breadcrumb">
      <a href="/">トップページ</a>&nbsp;≫&nbsp;<span>${f:h(webUser.webUserConfig.nickname)}さんのページ</span>
    </div>
  </div>
  <div class="content-left">
    <div class="cbox2">
      <div class="inner">
        <h1>${f:h(webUser.myPageConfig.title)}</h1>
        ${f:h(webUser.myPageConfig.description)}
      </div>
    </div>
    <c:forEach var="article" items="${articleList}" >
      <div class="cbox1">
        <div class="inner">
          <h1>${f:h(article.title)}</h1>
          <div style="padding-bottom: 10px;">
            ${article.createdAt}
          </div>
          ${func:wiki(func:truncate(article.text, 300, "..."))}
          <div>
            <a href="${article.url}">続きを読む</a>
          </div>
        </div>
      </div>
    </c:forEach>

  </div>

  <div class="content-right">
    <c:import url="/_widgets.jsp"></c:import>
  </div>
</c:param>
</c:import>
