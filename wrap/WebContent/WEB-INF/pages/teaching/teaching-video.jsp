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
	left: 400px;
	top: 150px;
}


.container .content-box .content-table .item{
	padding: 30px 150px;
	margin: 10px 20px;
	border: 3px dashed;	
}

.container .content-box .content-table .item a{
	font-size:30px;
	color: #abaaaa;
	text-decoration: none;
}

.container .content-box .content-table .item a:hover{
	color: #2c2c2c;
	text-decoration: underline;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-second.jsp" %>
	<div class="container">
		<div class="content-box">
			<table class="content-table" id="content-table">
				<embed src="http://player.youku.com/player.php/sid/XNzQ4NjY4NTQw/v.swf" allowFullScreen="true" quality="high" width="600" height="500" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function onLoad(){
			showBar("1");
			highlightItem("i2");
		}
	</script>
	
</body>
</html>

