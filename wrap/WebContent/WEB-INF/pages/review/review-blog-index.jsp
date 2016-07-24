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
	left: 150px;
	width:1000px;
	height:100%;
}

#content-box .nav{
	width: 100%;
	height: 30px;
	border-left: 3px solid #abaaaa;
}

#content-box .nav span{
	margin-left: 15px;
	font-size: 17px;
}

#content-box .list{
	width: 100%;
	min-height: 500px;
	margin-top: 10px;
	border-top: 1px solid #abaaaa;
}

#content-box .list .blogitem{
	margin-top: 10px;
	border-bottom: 1px solid #abaaaa;
	width: 100%;
	height: 120px;
}

#content-box .list .blogitem .coverimg{
	float: left;
	width: 150px;
	display: inline;
}

#content-box .list .blogitem .words{
	float: left;
	width: 600px;
	display: inline;
}

#content-box .list .blogitem .words span{
	font-size: 16px;
}

#content-box .list .blogitem .words a{
	font-size: 18px;
	text-decoration: none;
	color: #2c2c2c;
}

#content-box .list .blogitem .words a:hover{
	color: #abaaaa;
}
</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container" >
		<div id="content-box" style="min-height: 800px">
			<div class="nav">
				<span>复盘笔记</span>
			</div>
			<div class="list">
				<c:forEach var="item" items="${blogs}">
					<div class="blogitem">
						<div class="coverimg">
							<img src="${item.blogCoverUrl}" height="100px"/>
						</div>
						<div class="words">
							<div class="title">
								<span><a href="page/review/blog/blog?title=${item.blogTitle}">${item.blogTitle}</a></span>
							</div>
							<div class="description">
								${item.blogContent}
							</div>
							<span>作者:${item.blogAuthor}</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>浏览 :${item.blogAccessTime} </span>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	
	
	<script>
		function onLoad(){
			showBar("2");
			highlightItem("f1");
		}
	</script>
	
</body>
</html>

