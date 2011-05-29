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


tinyMCE.init({

	theme : "advanced",
	plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave",
	language: "ja",

	// Theme options
	theme_advanced_buttons1 : "bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,formatselect,fontsizeselect,|,undo,redo,|,link,unlink,anchor,image,cleanup,code,|,forecolor,backcolor",
	theme_advanced_buttons2 : "bullist,numlist,|,tablecontrols,|,hr,removeformat,visualaid",
	theme_advanced_buttons3 : "",
	theme_advanced_toolbar_location : "top",
	theme_advanced_toolbar_align : "left",
	theme_advanced_resizing : true,

    mode : "specific_textareas",
    editor_selector : "mce",



});

