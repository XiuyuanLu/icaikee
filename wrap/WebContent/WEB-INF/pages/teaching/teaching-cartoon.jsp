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
<link rel="stylesheet" type="text/css" href="resources/css/font-awesome/css/font-awesome.css" />
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/common/common.js"></script>
<style>

.container{
	padding-top:130px;
}

.container .cartoon{
	width: 60%;
	margin: 3% 20%;
}

.container .cartoon-title h3{
	text-align: center;
	font-size: 30px;
}

.container .cartoon-title .img-info{
	width: 80%;
	margin-left: 10%;
	margin-right: 10%;
	text-align: center;
	font-size: 18px;
}

.container .cartoon-content{
	height: 100%;
}

.container .cartoon-content img{
	width: 80%;
	margin-left: 10%;
	margin-right: 10%;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container clearfix">
		<div id="cartoon" class="cartoon" >
			<div id="cartoon-title" class="cartoon-title">
				<h3>${chapterId}:${cartoonName}</h3>
				<div class="img-info">
					<span>作者：${author }&nbsp;|&nbsp;浏览次数：${accessTime}</span>
					<br/><span id="description" title="${description }">简介：${description}</span>
				</div>
			</div>
			<br/>
			<div id="cartoon-content" class="cartoon-content">
				<img id="img" src="${url}" />
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	<div id="back-to-top">
		<a href="javascript:void(0)" onclick="backToTop()"><i class="fa fa-3x fa-arrow-up"></i></a>
	</div>
	<script>
		function onLoad(){
			showBar("1");
			highlightItem("i1");
		}
	</script>
	
</body>
</html>

