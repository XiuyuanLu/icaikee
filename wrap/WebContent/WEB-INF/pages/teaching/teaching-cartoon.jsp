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

.container .content-box{
	position: absolute;
	top: 30px;
	left: 100px;
	width:100%;
	display: inline;
}

.container .content-box .item{
	border: 1px solid #abaaaa;
	padding: 3px;	
	text-align:center;
	width:270px;
	float: left;
}

.container .content-box .item .item-img img{
	height: 200px;
}

.container .content-box .item a{
	font-size:15px;
	color: #abaaaa;
	text-decoration: none;
}

.container .content-box .item a:hover{
	color: #2c2c2c;
	text-decoration: underline;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container">
		<div class="content-box">
			<c:forEach var="item" items="${cartoons}">
				<div class="item">
					<div class="item-img">
						<img src="${item.indexUrl}" />
					</div>
					<a href="page/teaching/cartoon/img?chapterId=${item.chapterId}&cartoonName=${item.name}&url=${item.url}">${item.chapterId}</a>
				</div>
			</c:forEach> 
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function onLoad(){
			showBar("1");
			highlightItem("i1");
		}
	</script>
	
</body>
</html>

