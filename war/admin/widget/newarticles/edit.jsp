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
    <h1 class="h1-widget">ウィジェット</h1>
    <div class="form-post-wrapper">
      <form action="/admin/widget/newarticles/edit?id=${f:h(widget.key.id)}" method="post">
      <h2 class="section-title">新着記事</h2>
      <div class="record">
       <ul class="error">
         <c:forEach var="e" items="${f:errors()}">
           <li>${f:h(e)}</li>
         </c:forEach>
       </ul>
      </div>
      <div class="record">
        <label for="dispOrder">表示順</label>
        <div class="input short">
          <input id="dispOrder" class="text" type="text" ${f:text("dispOrder")} />
        </div>
      </div>
      <div class="record">
        <label for="maxSize">最大表示数</label>
        <div class="input short">
          <input id="dispOrder" class="text" type="text" ${f:text("maxSize")} />
        </div>
      </div>
      <div class="action">
        <input type="submit" value="保存する"/>
      </div>
      </form>

      <form action="/admin/widget/delete?id=${f:h(widget.key.id)}" method="post">
      <div class="action">
        <input type="submit" value="削除する"/>
      </div>
      </form>
    </div>
  </div>
</c:param>
</c:import>