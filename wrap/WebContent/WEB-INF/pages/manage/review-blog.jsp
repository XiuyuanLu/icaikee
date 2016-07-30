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
	padding-top: 100px;
}

.container .content{
	margin-left: 7%;
	margin-right: 7%;
	height: 700px;
	width: 84%;
}

.container .info {
	display: inline-block;
	position: absolute;
	width:300px;
	height: 90%;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	margin-top: 2%;
	margin-left: 30%;
	padding-left: 5px;
}

.container .info .title-span{
	font-size: 18px;
}

a{
	text-decoration: none;
	font-size: 18px;
	color: #2c2c2c;
}

a:hover{
	text-decoration: underline;
}

.container .info .maintain-list{
	overflow: auto;
}

.container .maintain{
	position: absolute;
	left: 60%;
	border: 1px solid #abaaaa;
	height:90%;
	width: 350px;
	display: none;
	box-shadow: 0 2px 2px #928d8d;
	margin: 2%;
}

.container .maintain .maintain-body{
	margin-left: 2%;
	font-size: 18px;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="content">
			<div class="info">
				<a id="new" href="page/manage/review/blog/edit?isUpdate=false">新增</a>
				<div class="maintain-list"> 
					<span class="title-span">维护</span>
					<c:forEach var="item" items="${blogs}">
						<div class="item">
							<a href="page/manage/review/blog/edit?title=${item.blogTitle}&isUpdate=true" >标题：${item.blogTitle}</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	<script>
	
	</script>
	
</body>
</html>

