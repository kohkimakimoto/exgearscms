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
      <a href="/admin/article/">記事</a>»
    </div>
    <h1 class="h1-content">記事を編集</h1>
    <c:import url="/admin/_messages.jsp" />
    <div class="form-post-wrapper">
      <form action="/admin/article/edit?id=${f:h(article.key.id)}" method="post">
      <h2 class="section-title">記事</h2>
      <div class="record">
       <ul class="error">
         <c:forEach var="e" items="${f:errors()}">
           <li>${f:h(e)}</li>
         </c:forEach>
       </ul>
      </div>
      <div class="record">
        <label>タイトル</label>
        <div class="input">
          <input class="text" type="text" ${f:text("title")} />
        </div>
      </div>
      <div class="record">
        <label>記事本文</label>
        <div class="input">
          <textarea class="mce" name="text">${f:h(text)}</textarea>
        </div>
      </div>
      <div class="action">
        <input type="submit" value="保存する"/>
      </div>
      </form>

      <form action="/admin/article/delete?id=${f:h(article.key.id)}" method="post">
      <div class="action">
        <input type="submit" value="削除する"/>
      </div>
      </form>
    </div>
  </div>
</c:param>
</c:import>