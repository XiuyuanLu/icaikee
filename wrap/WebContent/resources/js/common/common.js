$(document).ready(function (){
	if(typeof(onLoad) != "undefined"){
		onLoad();
	}
});

window.onscroll = function () {  
    var top = document.documentElement.scrollTop || document.body.scrollTop;  
    var hp = $('#head-parent');
    var ta = $('#triangle-down');
    var hs = $('#head-sub');
    var bk = $('#back-to-top');
    if(top>10){
    	hp.css("top","-50px");
    	hs.css("top","0px");
    	ta.css("display","none"); 
    	bk.css("display","block");
    	bk.css("top",top+500);
    }
    else{
    	hp.css("top","0px");
    	hs.css("top","50px");
    	ta.css("display","");
    	ta.css("top","50px");
    	bk.css("display","none");
    }
   
};

function redirect(path){
	location.href=path;
}

function showBar(title){
	var triangle = $("#triangle-down");
	var m1 = document.getElementById("menu-second-1");
	var m2 = document.getElementById("menu-second-2");
	var m3 = document.getElementById("menu-second-3");
	var length = $('.head-package').width();
	if(title=="1"){
		m1.style.display="";
		m2.style.display="none";
		m3.style.display="none";
		triangle.css("left",0.4305*length);
	}else if(title=="2"){
		m1.style.display="none";
		m2.style.display="";
		m3.style.display="none";
		triangle.css("left",0.5745*length);
	}else if(title=="3"){
		m1.style.display="none";
		m2.style.display="none";
		m3.style.display="";
		triangle.css("left",0.7191*length);
	}
}

function highlightItem(id){
	var item = $("#"+id);
	item.css('color','#2c2c2c');
}

function backToTop(){
	window.scrollTo(0,0);
}

function coming(){
	alert('coming soon。。。');
}