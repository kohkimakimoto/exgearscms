$(function() {

	// hover
	var postfix = '_h';
	$("img.hover").each(function(){
		var img = $(this);
		var src = img.attr('src');
		var src_on = src.substr(0, src.lastIndexOf('.'))
		           + postfix
		           + src.substring(src.lastIndexOf('.'));
		$(this).hover(function(){
			$(this).attr('src', src_on);
		}, function(){
			$(this).attr('src', src);
		});

	});

	// stripe
	$("table.stripe").each(function(){
		$(this).find("tr:even").addClass("even");
		$(this).find("tr:odd").addClass("odd");
	});

});





/*
$(document).ready(function(){
	$("#nav-one li").hover(
		function(){ $("ul", this).fadeIn("fast"); },
		function() { }
	);
	if (document.all) {
		$("#nav-one li").hoverClass ("sfHover");
	}
});

$.fn.hoverClass = function(c) {
	return this.each(function(){
		$(this).hover(
			function() { $(this).addClass(c);  },
			function() { $(this).removeClass(c); }
		);
	});
};
*/
