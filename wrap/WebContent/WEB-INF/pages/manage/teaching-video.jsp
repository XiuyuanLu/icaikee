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
			<form class="myForm" id="createVideo" 
				action="page/manage/teaching/video/upload" method="post" 
				enctype="multipart/form-data">
			  <p>视频名称: <input type="text" id="videoName" name="videoName" /></p>
			  <p>视频作者: <input type="text" id="videoAuthor" name="videoAuthor" /></p>
			  <p>视频链接: <input type="text" id="videoUrl"name="videoUrl" /></p>
			  <p>视频简介: <br/><textarea id="videoDescription" cols="35" rows="5" name="videoDescription"></textarea></p>
			  <p>封面文件: <input type="file" id="videoIndexFile" name="indexFile" /></p>
			  <input type="button" value="上传" onclick="lxySubmit()"/>
			</form>
		</div>
		<br/>
		<div class="info-m">
			<div class="maintain-list"> 
				<span class="title-span">维护</span>
				<c:forEach var="item" items="${videos}">
					<div class="item">
						<a href="javascript:void(0)" onclick="query('${item.videoName}')" >${item.videoName}</a>
					</div>
				</c:forEach>
			</div>
			<div id="maintain" class="maintain">
				<div class="maintain-body"> 
					<p>名称修改: <input id="videoNameForUpdate" type="text" name="videoName"/></p>
					<p>作者名称: <input id="videoAuthorForUpdate" type="text" name="videoAuthor" /></p>
					<p>链接修改: <input id="videoUrlForUpdate" type="text" name="videoUrl" /></p>
					<p>简介修改: <br/><textarea id="videoDescriptionForUpdate" cols="35" rows="5" name="videoDescription"></textarea></p>
					<p><a href="javascript:void(0)" onclick="update()">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					   <a href="javascript:void(0)" onclick="del()">删除视频</a></p>
					<form class="myForm" id="updateIndex"
					 		action="page/manage/teaching/video/index-update" method="post" 
							enctype="multipart/form-data">
					  <p>修改封面文件: <input type="file" id="indexFileForUpdate" name="index" /></p>
					  <input type="hidden" id="hiddenVideoName" name="videoName" />
					  <input type="button" value="上传" onclick="lxyIndexSubmit()"/>
					</form>
				</div>
			</div>
		</div>
		
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<input id="selectedVideo" type="hidden"/>
	<input id="videoNames" type="hidden" value="${videoNames}"/>
	<script>
		function lxySubmit(){
			var videoName=document.getElementById("videoName").value;
			var videoDescription=document.getElementById("videoDescription").value;
			var videoAuthor=document.getElementById("videoAuthor").value;
			var videoUrl=document.getElementById("videoUrl").value;
			var videoIndex=document.getElementById("videoIndexFile").value;
			if($.trim(videoName)==""){
				alert("请输入名称");
				return ;
			}
			if($.trim(videoAuthor)==""){
				alert("请输入作者");
				return ;
			}
			if($.trim(videoUrl)==""){
				alert("请输入链接");
				return ;
			}
			if($.trim(videoDescription)==""){
				alert("请输入简介");
				return ;
			}
			if($.trim(videoIndex)==""){
				alert("请添加封面文件");
				return ;
			}
			var videoNames = document.getElementById("videoNames").value;
			if(videoNames!=""){
				videoNames=videoNames.substring(1,videoNames.length-1);
				var array = videoNames.split(", ");
				for(var i=0;i<array.length;i++){
					if(videoName==array[i]){
						alert("视频名称已存在");
						return ;
					}
				}
			}
			document.getElementById("createVideo").submit();
		}
		
		function query(videoName){
			$.ajax({
				url:"api/teaching/video/query",
				data:{
					videoName:videoName
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
			document.getElementById("selectedVideo").value=data.videoName;
			document.getElementById("maintain").style.display="block";
			document.getElementById("videoNameForUpdate").value=data.videoName;
			document.getElementById("videoAuthorForUpdate").value=data.videoAuthor;
			document.getElementById("videoUrlForUpdate").value=data.videoUrl;
			document.getElementById("videoDescriptionForUpdate").value=data.videoDescription;
		}
		
		function update(){
			$.ajax({
				url:"api/teaching/video/update",
				data:{
					origVideoName:document.getElementById("selectedVideo").value,
					videoName :document.getElementById("videoNameForUpdate").value,
					videoAuthor :document.getElementById("videoAuthorForUpdate").value,
					videoUrl :document.getElementById("videoUrlForUpdate").value,
					videoDescription :document.getElementById("videoDescriptionForUpdate").value
				},
				type: 'POST',
				dataType: 'json',
				success:function(msg){
					alert("更新成功");
					location.href="page/manage/teaching/video";
				}
			});		
		}
		
		function del(){
			$.ajax({
				url:"api/teaching/video/delete",
				data:{
					videoName : document.getElementById("selectedVideo").value
				},
				type: 'POST',
				dataType: 'json',
				success:function(data){
					alert("删除成功");
					location.href="page/manage/teaching/video";
				}
			});		
		}
		
		function lxyIndexSubmit(){
			document.getElementById("hiddenVideoName").value=document.getElementById("selectedVideo").value;
			var indexFile = document.getElementById("indexFileForUpdate").value;
			if($.trim(indexFile)==""){
				alert("请添加封面文件");
				return ;
			}
			document.getElementById("updateIndex").submit();
		}
	</script>
	
</body>
</html>

