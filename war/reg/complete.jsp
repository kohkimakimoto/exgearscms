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
      <a href="/">トップページ</a>&nbsp;≫&nbsp;<span>ユーザアカウント登録</span>
    </div>
  </div>
  <div class="content-left">
    <div class="cbox1">
      <div class="inner">
        <h2>ユーザアカウント登録完了</h2>
        <div class="section">
          ExGearsCMSへのアカウント登録が完了しました。<br/>
          <br/>
          <a href="/">トップページ</a><br/>
          <br/>
          <a href="/admin/">管理ページ</a><br/>
        </div>
      </div>
    </div>
  </div>

  <div class="content-right">
  </div>
</c:param>
</c:import>