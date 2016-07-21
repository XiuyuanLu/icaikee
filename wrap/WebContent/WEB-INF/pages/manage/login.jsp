<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="functions" %>
<!DOCTYPE html>
<html>
<head>
<base href="${base}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/common/common.js"></script>
<style>

.container{
	top: 0;
	height: 100%;
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
			<form class="myForm" action="page/manage/login" method="post">
			  <p>用户名: <input type="text" name="username" /></p>
			  <p>密&nbsp;&nbsp;&nbsp;&nbsp;码: <input type="password" name="password" /></p>
			  <input type="submit" value="登录" />
			</form>
		</div>		
	</div>
	
	<script>
		function query(chapterId){
			$.ajax({
				url:"",
				data:{
				},
				dataType: 'json',
				success:function(data){
				}
			});
		}
	</script>
	
</body>
</html>

