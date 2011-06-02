<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<c:import url="/admin/layout/default.jsp">
<c:param name="title" value=""/>
<c:param name="content">
  <div class="content-left">
    <c:import url="/admin/_sidemenu.jsp" />
  </div>
  <div class="content-right">
    <div class="breadcrumb">
      <a href="/admin/">ダッシュボード</a>»
    </div>
    <h1 class="h1-config">マイページ設定</h1>
    <c:import url="/admin/_messages.jsp" />
    <div class="form-wrapper">
      <form action="/admin/config/mypage" method="post">
      <h2 class="section-title">設定</h2>
       <ul class="error">
         <c:forEach var="e" items="${f:errors()}">
           <li>${f:h(e)}</li>
         </c:forEach>
       </ul>
      <div class="record">
        <label>マイページのタイトル</label>
        <div class="input">
          <input class="text" type="text" ${f:text("title")} />
        </div>
      </div>
      <div class="record">
        <label>マイページの説明文</label>
        <div class="input">
          <textarea name="description">${f:h(description)}</textarea>
        </div>
      </div>
      <div class="action">
        <input type="submit" value="変更を保存する"/>
      </div>
      </form>
    </div>
  </div>
</c:param>
</c:import>