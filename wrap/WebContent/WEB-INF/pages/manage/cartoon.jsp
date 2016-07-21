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
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
}

.container .info .title-span{
	font-size: 18px;
}

a{
	text-decoration: none;
	font-size: 18px;
	color: #abaaaa;
}

a:hover{
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
	box-shadow: 0 2px 2px #928d8d;
}

.container .maintain .maintain-body{
	position: relative;
	left: 20%;
	top:20%;
	font-size: 18px;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="info">
			<span class="title-span">新增</span>
			<form class="myForm" action="page/manage/cartoon/upload" method="post" enctype="multipart/form-data">
			  <p>章&nbsp;节: <input type="text" name="chapterId" /></p>
			  <p>漫画名称: <input type="text" name="cartoonName" /></p>
			  <p>文件: <input type="file" name="img" /></p>
			  <input type="submit" value="上传" />
			</form>
		</div>
		<br/>
		<div class="info">
			<span class="title-span">维护</span>
			<c:forEach var="item" items="${cartoons}">
				<div class="item">
					<a href="javascript:void(0)" onclick="query('${item.chapterId}')" >${item.chapterId}</a>
				</div>
			</c:forEach>
		</div>
		
		<div id="maintain" class="maintain">
			<div class="maintain-body"> 
				<p>章&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;节: <input id="chapterIdForUpdate" type="text" name="chapterId"/></p>
				<p>漫画名称: <input id="cartoonNameForUpdate" type="text" name="cartoonName" /></p>
				<p><a href="javascript:void(0)" onclick="update()">保存</a></p>
				<p><a href="javascript:void(0)" onclick="del()">删除章节</a></p>
			</div>
		</div>		
		
	</div>
	<input id="selectedChapter" type="hidden"/>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function query(chapterId){
			$.ajax({
				url:"api/cartoon/query",
				data:{
					chapterId:chapterId
				},
				type: 'POST',
				dataType: 'json',
				success:function(data){
					show(data);
				}
			});
		}
		
		function show(data){
			if(data==null){
				alert("no data");
				return ;
			}
			document.getElementById("selectedChapter").value=data.chapterId;;
			var res = document.getElementById("maintain");
			res.style.display="block";
			var chapterId = document.getElementById("chapterIdForUpdate");
			var cartoonName = document.getElementById("cartoonNameForUpdate");
			chapterId.value=data.chapterId;
			cartoonName.value=data.name;
		}
		
		function update(){
			$.ajax({
				url:"api/cartoon/update",
				data:{
					origChapterId:document.getElementById("selectedChapter").value,
					chapterId:document.getElementById("chapterIdForUpdate").value,
					cartoonName:document.getElementById("cartoonNameForUpdate").value
				},
				type: 'POST',
				dataType: 'json',
				success:function(data){
					alert(data);
				}
			});		
		}
		
		function del(){
			$.ajax({
				url:"api/cartoon/delete",
				data:{
					chapterId:document.getElementById("selectedChapter").value
				},
				type: 'POST',
				dataType: 'json',
				success:function(data){
					alert(data);
				}
			});		
		}
	</script>
	
</body>
</html>

