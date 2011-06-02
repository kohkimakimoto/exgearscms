<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<div class="scbox1 user-info">
  <div class="inner">
    <div class="subject">ユーザ情報</div>
    <div class="user-uid">
      <!-- 
      <img src="/static/default/images/icon/user-22x22.png" /><a href="${webUser.url}">${webUser.uid}</a>
      -->
      <img src="${webUser.gravatarImageUrl}" /><a href="${webUser.url}">${webUser.uid}</a>
      
      <span style="color: #8e8e8e;">${f:h(webUser.webUserConfig.nickname)}</span>
    </div>
    ${f:h(webUser.webUserConfig.profile)}
  </div>
</div>
<c:import url="/_widgets.jsp"></c:import>
