<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.appspot.exgearscms.constant.Env"%>
<div>
<!-- tweet button -->
<a href="http://twitter.com/share" class="twitter-share-button" data-count="horizontal" data-lang="ja">Tweet</a><script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
<!-- facebook like button -->
<iframe src="http://www.facebook.com/plugins/like.php?app_id=205209079524180&amp;href&amp;send=false&amp;layout=button_count&amp;width=450&amp;show_faces=true&amp;action=like&amp;colorscheme=light&amp;font&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:450px; height:21px;" allowTransparency="true"></iframe>
</div>
<div>
<!-- hatebu button -->
<a href="http://b.hatena.ne.jp/entry/<%=Env.baseUrl%>${f:h(article.url)}" class="hatena-bookmark-button" data-hatena-bookmark-layout="standard" title="このエントリーをはてなブックマークに追加"><img src="http://b.st-hatena.com/images/entry-button/button-only.gif" alt="このエントリーをはてなブックマークに追加" width="20" height="20" style="border: none;" /></a><script type="text/javascript" src="http://b.st-hatena.com/js/bookmark_button.js" charset="utf-8" async="async"></script>
</div>
