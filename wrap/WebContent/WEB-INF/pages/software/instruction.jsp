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
	position: relative;
	top: 50px;
	left: 100px;
	width:100%;
	height:100%;
}

.container .content-box .software-title{
	text-align: center;
	position: absolute;
	left: 25%;
}

.container .content-box .software-title h3{
	font-size: 20px;
}

.container .content-box .software-content{
	position: absolute;
	top: 80px;
	left: 25%;
}

.container .content-box .software-content img{
	max-width: 500px;
	box-shadow: 0 2px 2px #928d8d;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container">
		<div class="content-box" style="min-height: 4600px">
			<div id="software-title" class="software-title">
				<h3>缠论指标</h3>
			</div>
			<div id="software-content" class="software-content">
				<img id="img" src="http://localhost:8888/img/指标文案.jpg" />
			</div>
		</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	
	<script>
		function onLoad(){
			showBar("3");
			highlightItem("s1");
		}
	</script>
	
</body>
</html>

