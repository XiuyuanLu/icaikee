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

.container .info {
	width:300px;
	height: 600px;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	position: relative;
	margin-bottom: 50px;
	padding-left: 5px;
	left: 50px;
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

.container .info-m {
	width:300px;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	position: absolute;
	left: 400px;
	top: 0px;
}

.container .info-m .maintain-list{
	max-height: 500px;
	overflow: auto;
}

.container .info-m .maintain{
	position: absolute;
	top: 0;
	left : 320px;
	border: 1px solid #abaaaa;
	height: 600px;
	width: 500px;
	display: none;
	box-shadow: 0 2px 2px #928d8d;
}

.container .info-m .maintain .maintain-body{
	position: relative;
	left: 15%;
	top:8%;
	font-size: 18px;
}

textarea{
	resize: none;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="info">
			<a href="page/manage/review/blog/edit">新增</a>
		</div>
		<br/>
		<div class="info-m">
			<div class="maintain-list"> 
				<span class="title-span">维护</span>
				<c:forEach var="item" items="${blogs}">
					<div class="item">
						<a href="page/manage/review/blog/edit?title=${item.blogTitle}" >${item.blogTitle}</a>
					</div>
				</c:forEach>
			</div>
		</div>
				
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<script>
	
	</script>
	
</body>
</html>

