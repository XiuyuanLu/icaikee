<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="functions" %>
<!DOCTYPE html>
<html>
<head>
<base href="${base}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>缠论君-后台管理</title>
<link rel="Shortcut Icon" href="resources/imgs/wrap.ico">
<link rel="Bookmark" href="resources/imgs/wrap.ico">
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/common/common.js"></script>
<style>

.container{
	padding-top:130px;
	height: 600px;
}

.container .login{
	width: 300px;
	height: 150px;
	border: 1px solid #abaaaa;
	position: relative;
	top: 30%;
	left: 40%;
}

.container .login .myForm{
	padding: 10% 10%; 
}

</style>

</head>

<body>
	<div class="container">
		<div id="login" class="login">
			  <p>用户名: <input type="text" id="username" /></p>
			  <p>密&nbsp;&nbsp;&nbsp;&nbsp;码: <input type="password" id="password" /></p>
			  <input type="button" value="登录" onclick="login()" />
		</div>		
	</div>
	
	<script>
		function login(){
			var username=document.getElementById("username").value;
			var password=document.getElementById("password").value;
			if($.trim(username)==""){
				alert("请输入用户名");
				return ;
			}
			if($.trim(password)==""){
				alert("请输入密码");
				return ;
			}
			$.ajax({
				url:"api/authenticate/login",
				data:{
					username: username,
					password: password
				},
				type: 'POST',
				dataType: 'json',
				success:function(data){
					if(data.message=="success")
						jump();
					else
						alert("用户名或密码错误");
				}
			});
		}
		
		function jump(){
			location.href="page/manage/teaching/cartoon";
		}
		
		document.onkeydown=function(event){
	        var e = event || window.event || arguments.callee.caller.arguments[0];
	        if(e && e.keyCode==13){
	        	 login();
	        }
	    }; 
		
	</script>
	
</body>
</html>

