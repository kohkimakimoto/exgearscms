<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="func" uri="/helper/functions"%>
<c:import url="/layout/default.jsp">
<c:param name="title" value="ExGearsCMS"/>
<c:param name="content" >
  <div class="content-top">
    <div class="breadcrumb">
      <a href="/">トップページ</a>&nbsp;≫&nbsp;<span>${webUser.uid}さんのページ</span>
    </div>
  </div>
  <div class="content-left">
    <div class="cbox1">
      <div class="inner">
        <h2>${f:h(webUser.config.myPageTitle)}</h2>
        <div class="section">
        ${f:h(webUser.config.myPageDescription)}
        </div>
      </div>
    </div>

    <div class="cbox1">
      <div class="inner">
        <h2>新着記事。</h2>
        <div class="section">
          <ul>
            <c:forEach var="article" items="${articleList}" >
              <li>
                <a style="font-weight: bold;" href="/${article.webUser.uid}/">${article.webUser.uid}</a>
                <a href="${article.url}">${func:truncate(article.title, 100)}</a>
                <div>${func:truncate(article.text, 100)}</div>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>


  </div>

  <div class="content-right">
    <c:import url="/user/_sidemenu.jsp">
      <c:param name="webUser" value="${webUser}"/>
    </c:import>
  </div>
</c:param>
</c:import>