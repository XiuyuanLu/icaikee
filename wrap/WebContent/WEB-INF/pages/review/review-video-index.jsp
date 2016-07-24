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

#content-box{
	position: relative;
	top: 50px;
	left: 100px;
	width:100%;
	height:100%;
}

#content-box .item{
	border: 1px solid #abaaaa;
	padding: 3px;
	margin: 5px;		
	text-align:center;
	width:270px;
	float: left;
}

#content-box .item .item-img img{
	height: 200px;
}

#content-box .item a{
	font-size:15px;
	color: #abaaaa;
	text-decoration: none;
}

#content-box .item a:hover{
	color: #2c2c2c;
	text-decoration: underline;
}

#description{
	display: block;
	width: 100%;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container" >
		<div id="content-box" style="min-height: 800px">
			<c:forEach var="item" items="${videos}">
				<div class="item">
					<div class="item-img">
						<img src="${item.videoIndexUrl}" />
					</div>
					<a href="page/review/video/video?videoName=${item.videoName}">${item.videoName}</a>
					<br/><span>作者：${item.videoAuthor}&nbsp;|&nbsp;浏览次数：${item.videoAccessTime}</span>
					<br/><span id="description" title="${item.videoDescription }">简介：${item.videoDescription }</span>
				</div>
			</c:forEach> 
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

