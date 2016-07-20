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

.container .cartoon{
	position:absolute;
	top: 50px;
	left: 390px;
	bottom: 50px;
	display: block;
	height: 100%;
	overflow: visible;
	border: 1px solid ;
	margin: 10px;
}

.container .cartoon-title h3{
	text-align: center;
	font-size: 30px;
}

.container .cartoon-content{
	height: 100%;
}

.container .cartoon-content img{
	max-width: 500px;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container clearfix">
		<div id="cartoon" class="cartoon">
			<div id="cartoon-title" class="cartoon-title">
				<h3>${chapterId}:${cartoonName}</h3>
			</div>
			<div id="cartoon-content" class="cartoon-content">
				<img id="img" src="${url}" />
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function onLoad(){
			showBar("1");
			highlightItem("i1");
			$('#cartoon-content').css('height',$("#img").outerHeight(true)+$("#cartoon-title h3").outerHeight(true));
			$('#cartoon').css('height',$("#img").outerHeight(true)+$("#cartoon-title h3").outerHeight(true));
			$('.container').css('height',$("#img").outerHeight(true)+$("#cartoon-title h3").outerHeight(true));
		}
	</script>
	
</body>
</html>

