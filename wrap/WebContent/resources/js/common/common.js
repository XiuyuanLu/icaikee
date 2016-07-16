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
    if(top>10){
    	hp.css("top","-50px");
    	hs.css("top","0px");
    	ta.css("display","none");
    }
    else{
    	hp.css("top","0px");
    	hs.css("top","50px");
    	ta.css("display","");
    	ta.css("top","50px");
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
	var m4 = document.getElementById("menu-second-4");
	var m5 = document.getElementById("menu-second-5");
	if(title=="1"){
		m1.style.display="";
		m2.style.display="none";
		m3.style.display="none";
		m4.style.display="none";
		m5.style.display="none";
		triangle.css("left",365);
	}else if(title=="2"){
		m1.style.display="none";
		m2.style.display="";
		m3.style.display="none";
		m4.style.display="none";
		m5.style.display="none";
		triangle.css("left",500);
	}else if(title=="3"){
		m1.style.display="none";
		m2.style.display="none";
		m3.style.display="";
		m4.style.display="none";
		m5.style.display="none";
		triangle.css("left",640);
	}else if(title=="4"){
		m1.style.display="none";
		m2.style.display="none";
		m3.style.display="none";
		m4.style.display="";
		m5.style.display="none";
		triangle.css("left",830);
	}else if(title=="5"){
		m1.style.display="none";
		m2.style.display="none";
		m3.style.display="none";
		m4.style.display="none";
		m5.style.display="";
		triangle.css("left",1000);
	}
}

function highlightItem(id){
	var item = $("#"+id);
	item.css('color','#2c2c2c');
}