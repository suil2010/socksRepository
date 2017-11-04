$(document).ready(function(){
	var now = 0;
	var imgs = $(".slide img");
	var limit = imgs.length - 1;
	
	imgs.eq(now).siblings().css({"left":"100%"});
	
	setInterval(function(){
		var pre = now;
		
		now = now >= limit ? 0 : now+1;
		
		imgs.eq(now).css({"left":"100%"});
		imgs.eq(pre).animate({"left":"-100%"},1000);
		imgs.eq(now).animate({"left":"0"},1000);
	},2000);
});