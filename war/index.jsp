<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<c:import url="/layout/default.jsp">
<c:param name="title" value="ExGearsCMS - Google App Engineで動作するオープンソースのクラウドCMS -"/>
<c:param name="content" >
  <div class="content-top">
    <div class="breadcrumb">
      <span>ここはトップぺーじです。</span>
    </div>
  </div>
  <div class="content-left">
    <div class="cbox1">
      <div class="inner">
        <h2>ExGearsCMSはオープンソースのクラウドCMSなんです。</h2>
        <div class="section">
          そんでもって以下の特徴があります。
          <ul class="cms-desc">
            <li>Google App Engineで動作します。</li>
            <li>Javaとslim3というフレームワークで構築されています。</li>
            <li>Googleアカウントでログインしてブログとか書けます。</li>
            <li><span style="font-weight: bold;">まだいろいろ開発中なので安定版はなかったりします。</span></li>
          </ul>
        </div>
        <h3>このサイトについて。</h3>
        <div class="section">
          このサイト自体をExGearsCMSで動かしています。<br />
          開発ブログの掲載とExGearsCMSを利用したゆるーいコミュニティサービスの提供を行っています。<br />
          さくっと使ってみたい人は下のリンクか右のメニューからアカウント登録してみてくださいね。<br />
          <br />
          <a href="/p/terms">利用規約</a><br />
          <a href="/reg/register">アカウント登録</a><br />
        </div>
        <h3>ソースコード。</h3>
        <div class="section">
          GitHubからダウンロードしてください。ライセンスはApache License 2.0です。<br />
          いまのところこのサイトで動作させているソースコードをそのままコミットしています。いずれブランチなどを切るかも。<br />
          <a href="https://github.com/kohkimakimoto/exgearscms">https://github.com/kohkimakimoto/exgearscms</a>
        </div>
        <h3>開発者のブログ。</h3>
        <div class="section">
          ExGearsCMSは@kohkimakimotoが個人で開発してます。<br />
          なんかあったらここに書くかも。<br />
          <a href="http://exgearscms.appspot.com/kohkimakimoto/">http://exgearscms.appspot.com/kohkimakimoto/</a>
        </div>
      </div>
    </div>

    <div class="cbox1">
      <div class="inner">
        <h2>新着記事。</h2>
        <div class="section">
          <ul>
            <c:forEach var="article" items="${articleList}" >
              <li><a href="${article.url}">${article.title}</a></li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>

  </div>

  <div class="content-right">
    <c:if test="${!user.authenticated}" >
      <div class="cbox1">
        <div class="inner">
          <a class="register" href="/reg/register"><img class="hover" src="/static/images/register_button.png" /></a>
          <p style="padding: 0 0 10px 0; font-size: 12px;">※ExGearsCMSはGoogleアカウントでユーザ認証をします。ご利用にはGoogleアカウントが必要です。</p>
          <hr style="border-bottom: 4px dotted #e2e2ff; border-top-width: 0; border-left-width: 0; border-right-width: 0; margin: 15px 0; " />
          <p style="padding: 0 0 10px 0; font-size: 12px;">すでに登録済みの方は</p>
          <a class="register" href="${loginUrl}"><img class="hover" src="/static/images/login_button.png" /></a>
          <p style="padding: 0 0 10px 0; font-size: 12px;">※Googleアカウントでログイン。</p>
        </div>
      </div>
    </c:if>
    <c:if test="${user.authenticated}" >
      <div class="cbox1 user-info">
        <div class="subject">ユーザメニュー</div>
        <div class="inner">
          <div class="user-uid">
            <img src="/static/images/icon/user-22x22.png" /><a href="${f:h(user.url)}">${f:h(user.uid)}</a>
          </div>
          <div class="user-menu">
            <ul>
              <li class="mail">${user.email}</li>
              <li><a href="/admin/">管理ページ</a></li>
              <li><a href="${f:h(user.url)}">Myページ</a></li>
              <li><a href="${f:h(logoutUrl)}">ログアウト</a></li>
            </ul>
          </div>
        </div>
      </div>
    </c:if>

    <div class="cbox1">
      <div class="subject">新着ユーザ</div>
      <div class="inner">
        <ul>
          <c:forEach var="webUser" items="${webUserList}" >
            <li class="user-uid"><img src="/static/images/icon/user-22x22.png" /><a href="${webUser.url}">${webUser.uid}</a></li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </div>
</c:param>
</c:import>