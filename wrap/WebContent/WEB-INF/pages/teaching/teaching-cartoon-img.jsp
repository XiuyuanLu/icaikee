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
	position: relative;
	top: 50px;
	left: 390px;
	display: block;
	overflow: visible;
	margin: 10px;
	margin-bottom: 100px;
	width:500px;
}

.container .cartoon-title h3{
	text-align: center;
	font-size: 30px;
}

.container .cartoon-title .img-info{
	text-align: center;
	font-size: 18px;
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
		<div id="cartoon" class="cartoon" style="min-height: 10100px">
			<div id="cartoon-title" class="cartoon-title">
				<h3>${chapterId}:${cartoonName}</h3>
				<div class="img-info">
					<span>作者：${author }&nbsp;|&nbsp;浏览次数：122</span>
					<br/><span id="description" title="${description }">简介：${description }</span>
				</div>
			</div>
			<br/>
			<div id="cartoon-content" class="cartoon-content">
				<img id="img" src="${url}" />
			</div>
		</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	
	<script>
		function onLoad(){
			showBar("1");
			highlightItem("i1");
			/* var height =$("#img").height();
			if(height>10100)
				$("#cartoon").css("height",height); */
		}
	</script>
	
</body>
</html>

