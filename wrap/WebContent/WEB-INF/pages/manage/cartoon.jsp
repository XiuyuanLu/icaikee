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
	height: 500px;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	position: relative;
	margin-bottom: 50px;
	padding-left: 5px;
	left: 50px;
}

.container .info .title-span{
	font-size: 18px;
}

a{
	text-decoration: none;
	font-size: 18px;
	color: #2c2c2c;
}

a:hover{
	text-decoration: underline;
}

.container .info-m {
	width:300px;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	position: absolute;
	left: 400px;
	top: 0px;
}

.container .info-m .maintain-list{
	max-height: 500px;
	overflow: auto;
}

.container .info-m .maintain{
	position: absolute;
	top: 0;
	left : 320px;
	border: 1px solid #abaaaa;
	height: 500px;
	width: 500px;
	display: none;
	box-shadow: 0 2px 2px #928d8d;
}

.container .info-m .maintain .maintain-body{
	position: relative;
	left: 15%;
	top:8%;
	font-size: 18px;
}

textarea{
	resize: none;
}

</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="info">
			<span class="title-span">新增</span>
			<form class="myForm" id="createCartoon" 
			 		action="page/manage/cartoon/upload" method="post" 
					enctype="multipart/form-data">
			  <p>章&nbsp;节: <input type="text" id="chapterId" name="chapterId" /></p>
			  <p>漫画名称: <input type="text" id="cartoonName" name="cartoonName" /></p>
			  <p>作者名称: <input type="text" id="author" name="author" value="Gaga"/></p>
			  <p>漫画简介: <br/><textarea cols="35" rows="5" id="description" name="description"></textarea></p>
			  <p>漫画文件: <input type="file" id="cartoonFile" name="img" /></p>
			  <p>封面文件: <input type="file" id="indexFile" name="index" /></p>
			  <input type="button" value="上传" onclick="lxySubmit()"/>
			</form>
		</div>
		<br/>
		<div class="info-m">
			<div class="maintain-list"> 
				<span class="title-span">维护</span>
				<c:forEach var="item" items="${cartoons}">
					<div class="item">
						<a href="javascript:void(0)" onclick="query('${item.chapterId}')" >${item.chapterId}</a>
					</div>
				</c:forEach>
			</div>
			<div id="maintain" class="maintain">
				<div class="maintain-body"> 
					<p>章节修改: <input id="chapterIdForUpdate" type="text" name="chapterId"/></p>
					<p>漫画名称: <input id="cartoonNameForUpdate" type="text" name="cartoonName" /></p>
					<p>作者修改: <input id="authorForUpdate" type="text" name="author" /></p>
					<p>简介修改: <br/><textarea id="descriptionForUpdate" cols="35" rows="5" name="description"></textarea></p>
					<p><a href="javascript:void(0)" onclick="update()">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <a href="javascript:void(0)" onclick="del()">删除章节</a></p>
				</div>
			</div>
		</div>
				
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<input id="selectedChapter" type="hidden"/>
	
	<script>
	
		function lxySubmit(){
			var chapterId=document.getElementById("chapterId").value;
			var cartoonName=document.getElementById("cartoonName").value;
			var author=document.getElementById("author").value;
			var description=document.getElementById("description").value;
			if($.trim(chapterId)==""){
				alert("请输入章节");
				return ;
			}
			if($.trim(cartoonName)==""){
				alert("请输入名称");
				return ;
			}
			if($.trim(author)==""){
				alert("请输入作者");
				return ;
			}
			if($.trim(description)==""){
				alert("请输入简介");
				return ;
			}
			document.getElementById("createCartoon").submit();
		}
	
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
			document.getElementById("maintain").style.display="block";
			document.getElementById("chapterIdForUpdate").value=data.chapterId;
			document.getElementById("cartoonNameForUpdate").value=data.name;
			document.getElementById("authorForUpdate").value=data.author;
			document.getElementById("descriptionForUpdate").value=data.description;
		}
		
		function update(){
			$.ajax({
				url:"api/cartoon/update",
				data:{
					origChapterId:document.getElementById("selectedChapter").value,
					chapterId:document.getElementById("chapterIdForUpdate").value,
					cartoonName:document.getElementById("cartoonNameForUpdate").value,
					author:document.getElementById("authorForUpdate").value,
					description:document.getElementById("descriptionForUpdate").value
				},
				type: 'POST',
				dataType: 'json',
				success:function(msg){
					alert("更新成功");
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
					alert("删除成功");
					location.href="page/manage/cartoon";
				}
			});		
		}
	</script>
	
</body>
</html>

