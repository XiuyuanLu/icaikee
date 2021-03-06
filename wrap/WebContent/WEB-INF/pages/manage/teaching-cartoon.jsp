<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="functions" %>
<!DOCTYPE html>
<html>
<head>
<base href="${base}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>缠论君-后台管理</title>
<link rel="Shortcut Icon" href="resources/imgs/wrap.ico">
<link rel="Bookmark" href="resources/imgs/wrap.ico">
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script src="resources/js/jquery-1.9.1.min.js"></script>
<script src="resources/js/common/common.js"></script>
<style>

.container{
	padding-top: 100px;
}

.container .content{
	margin-left: 7%;
	margin-right: 7%;
	height: 700px;
	width: 84%;
}

.container .info {
	display: inline-block;
	position: absolute;
	width:300px;
	height: 90%;
	border: 1px solid;
	border-color: #e6e0e0;
	box-shadow: 0 2px 2px #928d8d;
	font-size: 18px;
	margin: 2%;
	padding-left: 5px;
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

.container .info .maintain-list{
	overflow: auto;
}

.container .maintain{
	position: absolute;
	left: 60%;
	border: 1px solid #abaaaa;
	height:90%;
	width: 350px;
	display: none;
	box-shadow: 0 2px 2px #928d8d;
	margin: 2%;
}

.container .maintain .maintain-body{
	margin-left: 2%;
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
		<div class="content">
			<div class="info">
				<span class="title-span">新增</span>
				<form class="myForm" id="createCartoon" 
				 		action="page/manage/teaching/cartoon/upload" method="post" 
						enctype="multipart/form-data">
				  <p>章&nbsp;节: <input type="text" id="chapterId" name="chapterId" /></p>
				  <p>漫画名称: <input type="text" id="cartoonName" name="cartoonName" /></p>
				  <p>作者名称: <input type="text" id="author" name="author" value="Gaga"/></p>
				  <p>漫画简介: <br/><textarea cols="35" rows="5" id="description" name="description"></textarea></p>
				  <p>漫画文件: <input type="file" id="cartoonFile" name="imgs[]" multiple="multiple"/></p>
				  <p>封面文件: <input type="file" id="indexFile" name="index" /></p>
				  <input type="button" value="上传" onclick="lxySubmit()"/>
				</form>
			</div>
			<div class="info" style="left: 35%;">
				<div class="maintain-list"> 
					<span class="title-span">维护</span>
					<c:forEach var="item" items="${cartoons}">
						<div class="item">
							<a href="javascript:void(0)" onclick="query('${item.cartoonChapterId}')" >${item.cartoonChapterId}</a>
						</div>
					</c:forEach>
				</div>
			</div>
			<div id="maintain" class="maintain">
				<div class="maintain-body"> 
					<p>章节修改: <input id="chapterIdForUpdate" type="text" name="chapterId"/></p>
					<p>漫画名称: <input id="cartoonNameForUpdate" type="text" name="cartoonName" /></p>
					<p>作者修改: <input id="authorForUpdate" type="text" name="author" /></p>
					<p>简介修改: <br/><textarea id="descriptionForUpdate" cols="35" rows="5" name="description"></textarea></p>
					<p><a href="javascript:void(0)" onclick="update()">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <a href="javascript:void(0)" onclick="del()">删除章节</a></p>
					<form class="myForm" id="updateImg"
					 		action="page/manage/teaching/cartoon/img-update" method="post" 
							enctype="multipart/form-data">
					  <p>修改漫画文件: <input type="file" id="cartoonFileForUpdate" name="img" /></p>
					  <input type="hidden" id="imgChapterId" name="chapterId" />
					  <input type="button" value="上传" onclick="lxyImgSubmit()"/>
					</form>
					<form class="myForm" id="updateIndex"
					 		action="page/manage/teaching/cartoon/index-update" method="post" 
							enctype="multipart/form-data">
					  <p>修改封面文件: <input type="file" id="indexFileForUpdate" name="index" /></p>
					  <input type="hidden" id="indexChapterId" name="chapterId" />
					  <input type="button" value="上传" onclick="lxyIndexSubmit()"/>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	<input id="selectedChapter" type="hidden"/>
	<input id="cartoonChapters" type="hidden" value="${cartoonChapters}"/>
	<script>
	
		function lxySubmit(){
			var chapterId=document.getElementById("chapterId").value;
			var cartoonName=document.getElementById("cartoonName").value;
			var author=document.getElementById("author").value;
			var description=document.getElementById("description").value;
			var cartoonFile = document.getElementById("cartoonFile").value;
			var indexFile = document.getElementById("indexFile").value;
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
			if($.trim(cartoonFile)==""){
				alert("请添加漫画文件");
				return ;
			}
			if($.trim(indexFile)==""){
				alert("请添加封面文件");
				return ;
			}
			var cartoonChapters = document.getElementById("cartoonChapters").value;
			if(cartoonChapters!=""){
				cartoonChapters=cartoonChapters.substring(1,cartoonChapters.length-1);
				var array = cartoonChapters.split(", ");
				for(var i=0;i<array.length;i++){
					if(chapterId==array[i]){
						alert("章节已存在");
						return ;
					}
				}
			}
			document.getElementById("createCartoon").submit();
		}
	
		function lxyImgSubmit(){
			document.getElementById("imgChapterId").value=document.getElementById("selectedChapter").value;
			var cartoonFile = document.getElementById("cartoonFileForUpdate").value;
			if($.trim(cartoonFile)==""){
				alert("请添加漫画文件");
				return ;
			}
			document.getElementById("updateImg").submit();
		}
		
		function lxyIndexSubmit(){
			document.getElementById("indexChapterId").value=document.getElementById("selectedChapter").value;
			var indexFile = document.getElementById("indexFileForUpdate").value;
			if($.trim(indexFile)==""){
				alert("请添加封面文件");
				return ;
			}
			document.getElementById("updateIndex").submit();
		}
		
		function query(chapterId){
			$.ajax({
				url:"api/teaching/cartoon/query",
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
			document.getElementById("selectedChapter").value=data.cartoonChapterId;;
			document.getElementById("maintain").style.display="inline-block";
			document.getElementById("chapterIdForUpdate").value=data.cartoonChapterId;
			document.getElementById("cartoonNameForUpdate").value=data.cartoonName;
			document.getElementById("authorForUpdate").value=data.cartoonAuthor;
			document.getElementById("descriptionForUpdate").value=data.cartoonDescription;
		}
		
		function update(){
			$.ajax({
				url:"api/teaching/cartoon/update",
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
					location.href="page/manage/teaching/cartoon";
				}
			});		
		}
		
		function del(){
			$.ajax({
				url:"api/teaching/cartoon/delete",
				data:{
					chapterId:document.getElementById("selectedChapter").value
				},
				type: 'POST',
				dataType: 'json',
				success:function(data){
					alert("删除成功");
					location.href="page/manage/teaching/cartoon";
				}
			});		
		}
	</script>
	
</body>
</html>

