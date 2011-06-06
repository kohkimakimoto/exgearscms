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
    <div class="description">
      「ウィジェット」はページのサイドに表示される各種パーツです。いわゆるブログパーツとかそういうやつです。
    </div>
    <div class="content-table-wrapper">
    <table class="content-table stripe">
      <thead>
        <tr>
          <th colspan="2">利用中のウィジェット</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="var" items="${user.widgetList}">
        <tr>
          <td valign="top" class="first minrow">
            ${var.dispOrder}
          </td>
          <td valign="top" >
            <div style="border-left: 1px solid #e3e3e3; padding-left: 10px;">
              <div><span style="font-weight: bold;">${var.displayName}</span>&nbsp;<a href="/admin/widget/${var.name}/edit?id=${f:h(var.key.id)}">編集</a></div>
              <div style="padding-top: 10px;">${var.description}</div>
            </div>
          </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
    <div class="content-block-wrapper">
      <div class="content-block-header">利用可能なウィジェット<span style="font-size: 90%; font-weight: normal; margin-left: 10px;">※クリックして利用中に追加</span></div>
      <div class="content-block"><div class="inner">
        <div class="name"><a href="/admin/widget/userinfo/new">ユーザ情報</a></div>
        <div>プロフィールとアバター画像が表示される。</div>
      </div></div>

      <div class="content-block"><div class="inner">
        <div class="name"><a href="/admin/widget/newarticles/new">新着記事</a></div>
        <div>新着記事XX件のタイトルが表示される。</div>
      </div></div>

      <div class="content-block"><div class="inner">
        <div class="name"><a href="/admin/widget/twitter/new">ツイッターWidget</a></div>
        <div>自分のツイートが表示されるやつ。ツイッター公式で用意されてるJavaScriptのやつです。</div>
      </div></div>
    </div>
  </div>
</c:param>
</c:import>