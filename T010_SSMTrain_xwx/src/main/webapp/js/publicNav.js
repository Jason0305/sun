// JavaScript Document

/*顶部top--导航*/
$(function(){
	$("#tMenu .webnav").hover(function(){
		$(this).addClass("hover").find("div.top_hide_box").show();
	},function(){
		$(this).removeClass("hover").find("div.top_hide_box").hide();
	});
});
$(function(){
  $("#tMenu .webnavdh").hover(function(){
    $(this).addClass("hover").find(".top_hide_box").show();
  },function(){
    $(this).removeClass("hover").find(".top_hide_box").hide();
  });
});