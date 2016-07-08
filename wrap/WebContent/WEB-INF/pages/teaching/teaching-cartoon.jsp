<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="functions" %>
<!DOCTYPE html>
<html>
<head>
<base href="${base}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="/wrap/resources/css/main.css" />
<script src="/wrap/resources/js/common/common.js"></script>
<style>

.container .content-box .content-table{
	margin: 160px 240px 20px 300px;
}

.container .content-box .content-table .item{
	padding: 30px 150px;
	margin: 10px 20px;
	border: 3px dashed;	
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-teaching.jsp" %>
	<div class="container">
		<div class="content-box">
			<img id="img" src="${url}"/>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		
	</script>
	
</body>
</html>

