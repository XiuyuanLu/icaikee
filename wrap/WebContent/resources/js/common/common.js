$(document).ready(function (){
	if(typeof(onLoad) != "undefined"){
		onLoad();
	}
});

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