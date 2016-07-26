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

.container .blog{
	position: relative;
	top: 5px;
	left: 290px;
	display: block;
	overflow: visible;
	margin: 10px;
	margin-bottom: 100px;
	width: 800px;
	height: 800px;
}

.container .blog-title{
	width: 700px;
}

.container .blog-title h3{
	text-align: center;
	font-size: 18px;
}

.container .blog-title .blog-info{
	text-align: center;
	font-size: 12px;
}

.container .blog-content{
	border-top: 1px solid #abaaaa;
	height: 80%;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container" style="min-height:800px;">
		<div id="blog" class="blog">
			<div id="blog-title" class="blog-title">
				<h3>${blog.blogTitle}</h3>
				<div class="blog-info">
					<span>作者：${blog.blogAuthor}&nbsp;|&nbsp;浏览次数：${blog.blogAccessTime}</span>
				</div>
			</div>
			<br/>
			<div id="blog-content" class="blog-content">
				<article id="article">
					${blog.blogContent}
				</article>
			</div>
		</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	
	<script>
		function onLoad(){
			showBar("2");
			highlightItem("f1");
			$('.container').css('height',$('#article').height()+300);
			$('#blog').css('height',$('#article').height()+300);
		}
	</script>
	
</body>
</html>

