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
	height: 300px;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	position: relative;
	margin-bottom: 50px;
	padding-left: 50px;
	padding-top: 100px;
	left: 500px;
}

.container .info .title-span{
	font-size: 18px;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="info">
			<form class="myForm" action="page/manage/software/instruction/upload" method="post" 
					enctype="multipart/form-data" target="_blank">
			  <p>指标文案: <input type="file" name="instruction" /></p>
			  <input type="submit" value="上传" />
			</form>
		</div>
		<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	
	<script>
	</script>
	
</body>
</html>

