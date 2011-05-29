<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<c:import url="/layout/default.jsp">
<c:param name="title" value="ExGearsCMS"/>
<c:param name="content" >
  <div class="content-top">
    <div class="breadcrumb">
      <a href="/">トップページ</a>&nbsp;≫&nbsp;<a href="${webUser.url}">${webUser.uid}さんのページ</a>&nbsp;≫&nbsp;<span>${article.title}</span>
    </div>
  </div>
  <div class="content-left">
    <div class="cbox1">
      <div class="inner">
        <h1>${f:h(article.title)}</h1>
        <div class="section">
        ${article.text}
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