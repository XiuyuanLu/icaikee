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

.container .info {
	width:300px;
	border: 1px solid;
	border-color: #e6e0e0;
}

.container .info .title-span{
	font-size: 18px;
}

.container .info .item a{
	text-decoration: none;
	font-size: 18px;
	color: #abaaaa;
}

.container .info .item a:hover{
	text-decoration: underline;
	color: #2c2c2c;
}

.container .maintain{
	position: absolute;
	top: 50px;
	left: 500px;
	border: 1px solid #abaaaa;
	height: 300px;
	width: 700px;
	display: none;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="info">
			<span class="title-span">上传</span>
			<form class="myForm" action="page/manage/cartoon/upload" method="post" enctype="multipart/form-data">
			  <p>章&nbsp;节: <input type="text" name="chapterId" /></p>
			  <p>漫画名称: <input type="text" name="cartoonName" /></p>
			  <p>文件: <input type="file" name="img" /></p>
			  <input type="submit" value="上传" />
			</form>
		</div>
		
		<div class="info">
			<span class="title-span">维护</span>
			<c:forEach var="item" items="${cartoons}">
				<div class="item">
					<a href="javascript:void(0)" onclick="query('${item.chapterId}')" >${item.chapterId}</a>
				</div>
			</c:forEach>
		</div>
		
		<div id="maintain" class="maintain">
			
		</div>		
		
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function query(chapterId){
			$.ajax({
				url:"api/singleCartoon",
				data:{
					chapterId:chapterId
				},
				dataType: 'json',
				success:function(data){
					show(data);
				}
			});
		}
		
		function show(data){
			var res = document.getElementById("maintain");
			res.style.display="block";
			res.innerHTML=data.chapterId;
		}
	</script>
	
</body>
</html>

