<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="func" uri="/helper/functions"%>
<c:import url="/layout/default_user.jsp">
<c:param name="title" value="${f:h(webUser.myPageConfig.title)} | EXGearsCMS"/>
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
    <c:forEach var="article" items="${pager.results}" >
      <div class="cbox1">
        <div class="inner">
          <h1>${f:h(article.title)}</h1>
          <div style="padding-bottom: 10px;">
            ${func:d(article.createdAt)}
          </div>
          ${func:wiki(func:truncate(article.text, 100, "..."))}
          <div>
            <a href="${article.url}">続きを読む</a>
          </div>
        </div>
      </div>
    </c:forEach>
    <c:import url="/_pager.jsp" >
      <c:param name="page" value="${page}"/>
    </c:import>

  </div>

  <div class="content-right">
    <c:import url="/_widgets.jsp"></c:import>
  </div>
</c:param>
</c:import>
