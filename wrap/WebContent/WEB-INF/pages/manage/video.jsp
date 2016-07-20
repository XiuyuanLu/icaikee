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
<script src="resources/js/common/common.js"></script>
<style>

.container .info {
	position: absolute;
	left: 400px;
	top: 250px;
	border: 1px solid;
	border-color: #e6e0e0;
	padding: 50px 100px;
}

.container .info .myForm{

}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="info">
			<form class="myForm" action="page/manage/video/upload" method="post" enctype="multipart/form-data">
			  <p>文件: <input type="file" name="video" /></p>
			  <input type="submit" value="上传" />
			</form>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		
	</script>
	
</body>
</html>
