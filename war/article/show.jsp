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
        <h2>${f:h(article.title)}</h2>
        <div class="section">
        ${f:h(article.text)}
        </div>
      </div>
    </div>
  </div>

  <div class="content-right">
    <div class="cbox1 user-info">
      <div class="subject">ユーザ情報</div>
      <div class="inner">
        <div class="user-uid">
          <img src="/static/images/icon/user-22x22.png" /><a href="${f:h(webUser.url)}">${f:h(webUser.uid)}</a>
        </div>
        ${f:h(webUser.config.profile)}
      </div>
    </div>
  </div>
</c:param>
</c:import>