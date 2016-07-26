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
<link rel="stylesheet" type="text/css" href="resources/css/slides.css" />
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/slidesjs/jquery.SuperSlide.2.1.1.js"></script>
<script src="resources/js/common/common.js"></script>

<style>

.container .slideBox .bd li img{
	width: 1280px;
	height: 500px;
}

.container img{
	width: 100%;
	height: 100%;
	font-size: 0;
}
</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header.jsp" %>
	<div class="container" style="top: 100px">
		<div id="slideBox" class="slideBox">
			<div id="hd" class="hd">
				<ul>
					<li>1</li>
					<li>2</li>
					<li>3</li>
				</ul>
			</div>
			<div class="bd">
				<ul>
					<li><img src="resources/imgs/home/home1.png" /></li>
					<li><img src="resources/imgs/home/home2.png" /></li>
					<li><img src="resources/imgs/home/home3.png" /></li>
				</ul>
			</div>

			<a class="prev" href="javascript:void(0)"></a>
			<a class="next" href="javascript:void(0)"></a>
		</div>
		<img src="resources/imgs/home/home1.png" />
		<img src="resources/imgs/home/home2.png" />
		<img src="resources/imgs/home/home3.png" />
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	
	<script>
		jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true,titCell: ".hd li",trigger:"click"});
	</script>
	
</body>
</html>

