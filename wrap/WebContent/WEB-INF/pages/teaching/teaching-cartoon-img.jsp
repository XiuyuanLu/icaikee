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

#cartoon{
	position:absolute;
	top: 150px;
	left: 390px;
	bottom: 50px;
}

#cartoon-title h3{
	text-align: center;
	font-size: 30px;
}

#cartoon-content img{
	max-width: 500px;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container">
		<div id="cartoon">
			<div id="cartoon-title">
				<h3>${chapterId}:${cartoonName}</h3>
			</div>
			<div id="cartoon-content">
				<img src="${url}">
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function onLoad(){
			showBar("1");
			highlightItem("i1");
		}
	</script>
	
</body>
</html>

