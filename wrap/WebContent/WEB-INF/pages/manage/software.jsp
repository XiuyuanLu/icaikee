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
	height: 500px;
	width: 84%;
}

.container .info {
	display: inline-block;
	position: absolute;
	width:300px;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	margin-top: 2%;
	margin-left: 30%;
	margin-right: 20%;
	padding-left: 5px;
}


.container .info span{
	font-size: 18px;
	border-left: 3px solid #abaaaa;
	padding-left: 10px;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="content">
			<div class="info">
				<form class="myForm" action="page/manage/software/instruction/upload" method="post" 
						enctype="multipart/form-data">
				  <p><span>指标文案:</span> <input type="file" name="instruction" /></p>
				  <input type="submit" value="上传" />
				</form>
				<form class="myForm" action="page/manage/software/software/upload" method="post" 
						enctype="multipart/form-data">
				  <p><span>指标软件:</span> <input type="file" name="software" /></p>
				  <input type="submit" value="上传" />
				</form>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
	</script>
	
</body>
</html>

