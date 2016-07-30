<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="functions" %>
<!DOCTYPE html>
<html>
<head>
<base href="${base}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>缠论君-缠论第一站</title>
<link rel="Shortcut Icon" href="resources/imgs/wrap.ico">
<link rel="Bookmark" href="resources/imgs/wrap.ico">
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/common/common.js"></script>
<style>

.container{
	padding-top:130px;
}

.container .content-box{
	width: 60%;
	margin: 3% 20%;
}

.container .content-box .software-title{
	text-align: center;
	width: 80%;
	margin-left: 10%;
	margin-right: 10%;
	margin-bottom: 5%;
}

.container .content-box .software-title a{
	font-size: 20px;
	color: #2c2c2c;
}

.container .content-box .software-title a:hover{
	color: #abaaaa;
}

.container .content-box .software-content{
	left: 25%;
	height: 100%;
}

.container .content-box .software-content img{
	width: 80%;
	margin-left: 10%;
	margin-right: 10%;
	box-shadow: 0 2px 2px #928d8d;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container">
		<div class="content-box">
			<div id="software-title" class="software-title">
				<a href="${downloading}">点此下载软件压缩包</a>
			</div>
			<div id="software-content" class="software-content">
				<img id="img" src="${url}" />
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function onLoad(){
			showBar("3");
			highlightItem("s1");
		}
	</script>
	
</body>
</html>

