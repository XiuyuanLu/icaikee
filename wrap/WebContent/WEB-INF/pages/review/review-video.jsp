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

.container .video{
	position: relative;
	top: 5px;
	left: 290px;
	display: block;
	overflow: visible;
	margin: 10px;
	margin-bottom: 100px;
	width:500px;
}

.container .video-title{
	width: 700px;
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
	height: 100%;
}

embed{
	width: 700px;
	height: 560px;
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
			<span id="description" title="${video.videoDescription}">简介：${video.videoDescription}</span>
		</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	
	<script>
		function onLoad(){
			showBar("2");
			highlightItem("f2");
		}
	</script>
	
</body>
</html>
