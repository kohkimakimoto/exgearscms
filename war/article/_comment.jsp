<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="com.appspot.exgearscms.constant.Env"%>
<% if (Env.disqusShortName != null && !Env.disqusShortName.equals("")) {  %>
<div id="disqus_thread"></div>
<script type="text/javascript">
    /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
    var disqus_shortname = '<%=Env.disqusShortName%>';

    // The following are highly recommended additional parameters. Remove the slashes in front to use.
    var disqus_identifier = '<%=Env.baseUrl%>${f:h(article.url)}';
    var disqus_url = '<%=Env.baseUrl%>${f:h(article.url)}';

    /* * * DON'T EDIT BELOW THIS LINE * * */
    (function() {
        var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
        dsq.src = 'http://' + disqus_shortname + '.disqus.com/embed.js';
        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
    })();
</script>
<noscript>Please enable JavaScript to view the <a href="http://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
<a href="http://disqus.com" class="dsq-brlink">blog comments powered by <span class="logo-disqus">Disqus</span></a>
<%}%>