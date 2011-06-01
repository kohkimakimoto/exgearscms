<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="func" uri="/helper/functions"%>
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
        <h1>ExGearsCMSはオープンソースのクラウドCMSなんです。</h1>
        そんでもって以下の特徴があります。
        <ul class="cms-desc">
          <li>Google App Engineで動作します。</li>
          <li>Javaとslim3というフレームワークで構築されています。</li>
          <li>Googleアカウントでログインしてブログとか書けます。</li>
          <li><span style="font-weight: bold;">まだいろいろ開発中なので安定版はなかったりします。</span></li>
        </ul>
        <h2>このサイトについて。</h2>
        このサイト自体をExGearsCMSで動かしています。<br />
        ExGearsCMSに関する情報や誰でも使えるゆるーいブログサービスの提供などを行っています。<br />
        無料で使えるので気になるヒトは右のメニューからアカウント登録してみてくださいね。<br />
        ただしまだ安定していないので、データ消えたりするかも<br />
        <br />
        <a href="/p/terms">利用規約</a><br />
        <a href="/reg/register">アカウント登録</a><br />
        <h2>ソースコード。</h2>
        GitHubからダウンロードしてください。ライセンスはApache License 2.0です。<br />
        いまのところこのサイトで動作させているソースコードをそのままコミットしていますのでご注意ください。いずれ汎用的に使えるバージョンを用意してブランチなどを切る予定です。<br />
        <a href="https://github.com/kohkimakimoto/exgearscms">https://github.com/kohkimakimoto/exgearscms</a>
        <h2>開発者のブログ。</h2>
        ExGearsCMSは@kohkimakimotoが個人で開発してます。<br />
        なんかあったらここに書くかも。<br />
        <a href="http://exgearscms.appspot.com/kohkimakimoto/">http://exgearscms.appspot.com/kohkimakimoto/</a>
      </div>
    </div>

    <div class="cbox1">
      <div class="inner">
        <h1>新着記事。</h1>
        <ul>
          <c:forEach var="article" items="${articleList}" >
            <li>
              <a style="font-weight: bold;" href="/${article.webUser.uid}/">${article.webUser.uid}</a>
              <a href="${article.url}">${f:h(article.title)}</a>
              <span>${article.createdAt}</span>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>

  </div>

  <div class="content-right">
    <c:if test="${!user.authenticated}" >
      <div class="scbox1">
        <div class="inner">
        <div class="subject">はじめてみる？</div>
          <a class="register" href="/reg/register"><img class="hover" src="/static/default/images/common/register_button.png" /></a>
          <p style="padding: 0 0 10px 0; font-size: 12px;">※ExGearsCMSはGoogleアカウントでユーザ認証をします。ご利用にはGoogleアカウントが必要です。</p>
          <hr style="border-bottom: 4px dotted #e2e2ff; border-top-width: 0; border-left-width: 0; border-right-width: 0; margin: 15px 0; " />
          <p style="padding: 0 0 10px 0; font-size: 12px;">すでに登録済みの方は</p>
          <a class="register" href="${loginUrl}"><img class="hover" src="/static/default/images/common/login_button.png" /></a>
          <p style="padding: 0 0 10px 0; font-size: 12px;">※Googleアカウントでログイン。</p>
        </div>
      </div>
    </c:if>
    <c:if test="${user.authenticated}" >
      <div class="scbox1 user-info">
        <div class="inner">
        <div class="subject">ユーザメニュー</div>
          <div class="user-uid">
            <img src="/static/default/images/icon/user-22x22.png" /><a href="${f:h(user.url)}">${f:h(user.uid)}</a>
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

    <div class="scbox1">
      <div class="inner">
        <div class="subject">登録してるユーザさん</div>
        <ul>
          <c:forEach var="webUser" items="${webUserList}" >
            <li class="user-uid">
              <img src="/static/default/images/icon/user-22x22.png" /><a href="${webUser.url}">${webUser.uid}</a>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </div>
</c:param>
</c:import>