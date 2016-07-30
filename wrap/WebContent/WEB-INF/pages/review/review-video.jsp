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
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/common/common.js"></script>
<style>

.container{
	padding-top:130px;
}

.container .video{
	margin: 2% 15%;
	width:70%;
}

.container .video-title{
	width: 60%;
	margin-left: 20%;
	margin-right: 20%;
}

.container .video-title h3{
	text-align: center;
	font-size: 18px;
}

.container .video-title .video-info{
	text-align: center;
	font-size: 12px;
}

.container .video-content{
	width: 70%;
	margin-left: 15%;
	margin-right: 15%;
	margin-bottom:5%;
	height: 500px;
}

.container .des{
	width: 70%;
	margin-left: 15%;
	margin-right: 15%;
}

embed{
	width: 100%;
	height: 100%;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container clearfix">
		<div id="video" class="video">
			<div id="video-title" class="video-title">
				<h3>${video.videoName}</h3>
				<div class="video-info">
					<span>作者：${video.videoAuthor}&nbsp;|&nbsp;浏览次数：${video.videoAccessTime}</span>
				</div>
			</div>
			<br/>
			<div id="video-content" class="video-content">
				${video.videoUrl}
			</div>
			<div class="des">
				<span>视频简介：</span>
				<br/>
				<artical>
					${video.videoDescription}
				</artical>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function onLoad(){
			showBar("2");
			highlightItem("f2");
		}
	</script>
	
</body>
</html>

