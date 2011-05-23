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
        <h2>ユーザアカウント登録</h2>
        <div class="section">
          ExGearsCMSへのアカウント登録は簡単です。<br/>
          ご利用のGoogleアカウントでログインした状態で、お好きなユーザIDを入力するだけで済みます。<br/>
          <c:if test="${!user.authenticated && user.guser == null}" >
          <br/>
          ExGearsCMSはアカウント管理にGoogleアカウントを利用します。<br />
          まずはGoogleアカウントにログインしてください。<br />
          ※ExGearsCMSがGoogleアカウントのパスワードを取得することはありません。<br />
          </c:if>
        </div>
        <div class="section">
          <c:if test="${user.authenticated}" >
            おっと、すでに登録してログイン済みのようですね。
          </c:if>
          <c:if test="${!user.authenticated && user.guser == null}" >
            <a href="${f:h(loginUrl)}">≫Googleアカウントにログイン</a>
          </c:if>
          <c:if test="${!user.authenticated && user.guser != null}" >
            <div style="border-top: 1px dotted #e3e3e3; border-bottom: 1px dotted #e3e3e3; padding: 10px 0;">
            現在ログイン中のあなたのGoogleアカウントは<br />
            <table class="ginfo">
              <tr>
                <th>ニックネーム:</th>
                <td>${user.guser.nickname}</td>
              </tr>
              <tr>
                <th>Email:</th>
                <td>${user.guser.email}</td>
              </tr>
            </table>
            ですね。<br/>
            <br/>
            このGoogleアカウントでExGearsCMSに登録します。<br/>
            ExGearsCMSで使用するユーザIDを入力してください。<br />
            このユーザIDからユーザごとのページが以下のようなURLで構築されます。<br />
            <br />
            http://exgearscms.appspot.com/[ユーザーID]/<br />
            <br />
            <form class="form-register" action="/reg/register" method="post">
              <ul class="error">
                <c:forEach var="e" items="${f:errors()}">
                <li>${f:h(e)}</li>
                </c:forEach>
              </ul>
              <table class="register-info">
                <tr>
                  <td>
                    <label>ユーザID:</label><br/>
                    <input type="text" ${f:text("uid")} /><br/>
                    *半角英数とアンダースコアで4文字以上100字以内で指定。また先頭にアンダースコアは使えません。
                  </td>
                </tr>
                <tr>
                  <td><input type="submit" value="登録する" /></td>
                </tr>
              </table>
            </form>

            <div style="border: 1px solid #e3e3ff; padding: 10px; background: #f3f3ff; margin: 10px 0;">
              ※別のGoogleアカウントで登録したい場合は、一度ログアウトしてExGearsCMSをご利用になるGoogleアカウントで再度ログインしてください。<br/>
              <a href="${f:h(logoutUrl)}">≫Googleアカウントからログアウト</a><br/>
            </div>

            </div>
          </c:if>
        </div>
      </div>
    </div>
  </div>

  <div class="content-right">
  </div>
</c:param>
</c:import>