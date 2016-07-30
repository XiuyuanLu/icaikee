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

.container .blog{
	margin: 5% 15%;
	width:70%;
}

.container .blog .blog-title{
	width: 60%;
	margin-left: 20%;
	margin-right: 20%;
}

.container .blog .blog-title h3{
	text-align: center;
	font-size: 18px;
}

.container .blog .blog-title .blog-info{
	text-align: center;
	font-size: 12px;
}

.container .blog .blog-content{
	border-top: 1px solid #abaaaa;
	height: 100%;
	min-height: 500px;
}


</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container">
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
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	<div id="back-to-top">
		<a href="javascript:void(0)" onclick="backToTop()"><i class="fa fa-3x fa-arrow-up"></i></a>
	</div>
	<script>
		function onLoad(){
			showBar("2");
			highlightItem("f1");
		}
	</script>
	
</body>
</html>

