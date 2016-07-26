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
<script src="resources/js/tinymce/tinymce.min.js"></script>
<style>

.container .info {
	position: relative;
	width: 900px;
	left: 100px;
	border: 1px solid;
	border-color: #e6e0e0;
	padding: 0px 100px 50px 100px;
	margin-bottom: 100px;
}

#title-bar{
	margin-top: 30px;
	padding: 10px;
}

#title,#author{
	font-size: 16px;
}

#blog-title{
	width: 300px;
}

#blog{
	margin-top: 20px;
	margin-bottom: 50px;
}

#publish{
	font-size: 16px;
	text-decoration: none;
	color: #5a5a5a;
	border: 1px solid #abaaaa;
	background: #abaaaa;
	padding: 4px;
	position: absolute;
	left: 45%;
}

#publish:hover{
	border: 1px solid #e6e6e6;
	background: #e6e6e6;
}
</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container" style="min-height: 900px;">
		<div class="info">
			<div id="title-bar">
				<span id="title">文章标题：</span><input id="blog-title" type="text" value="${title}"/><br/><br/>
				<span id="author">文章作者：</span><input id="blog-author" type="text" />
			</div>
			<div id="blog">
				<textarea id="blog-content"></textarea>
			</div>
			<a id="publish" href="javascript:void(0)" onclick="lxySubmit()">保存文章</a>
			<form class="myForm" id="uploadIndex"
				action="page/manage/review/blog/cover" method="post" 
				enctype="multipart/form-data" style="display:none">
			    <p>封面文件: <input type="file" id="indexFile" name="indexFile" /></p>
				<input type="hidden" id="hiddenTitle" name="title" />
				<input type="button" value="上传" onclick="lxyIndexSubmit()"/>
			</form>
		</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	</div>
	<iframe id="form_target" name="form_target" style="display:none"></iframe>
	<form id="my_form" action="page/manage/review/blog/img" target="form_target" method="post" enctype="multipart/form-data" style="width:0px;height:0;overflow:hidden">
	    <input name="img" type="file" onchange="getUrl()">
	</form>
	<input type="hidden" id="savepath" value="${savePath}" />
	<script>
		function onLoad(){
			tinymce.init({
			    selector: '#blog-content',
			    theme: 'modern',
			    width: 850,
			    height: 500,
			    plugins: [
			      'advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker',
			      'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
			      'save table contextmenu directionality emoticons template paste textcolor'
			    ],
			    toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image imagetools| print preview media fullpage | forecolor backcolor emoticons | fontselect | fontsizeselect',
			    language:'zh_CN',
			    automatic_uploads: true,
			    file_browser_callback: function(field_name, url, type, win) {
			    	field = field_name;
			    	if(type=='image') 
			    		$('#my_form input').click();
			    },
			    file_browser_callback_types: 'file image media'
			  });
			getBlog();
		}
		
		function getUrl(){
			var array = $('#my_form input').val().split('\\');
			if(array!=null)
				document.getElementById(field).value=document.getElementById('savepath').value
													+array[array.length-1];
			$('#my_form').submit();
		}
		
		function getBlog(){
			var t = document.getElementById("blog-title").value;
			if(t!=""){
				$.ajax({
					url:"api/review/blog/query",
					data:{
						title: t
					},
					type: 'POST',
					dataType: 'json',
					success:function(data){
						document.getElementById('blog-author').value = data.message.blogAuthor;
						$('#blog-content').html(data.message.blogContent);
					}
				});
			}
		}
		
		function lxySubmit(){
			
			var title=document.getElementById("blog-title").value;
			var author=document.getElementById("blog-author").value;
			if($.trim(title)==""){
				alert("请输入标题");
				return ;
			}
			if($.trim(author)==""){
				alert("请输入作者");
				return ;
			}
			
			var content = tinymce.activeEditor.getContent();
			$.ajax({
				url:"api/review/blog/publish",
				data:{
					title: title,
					author: author,
					content: content
				},
				type: 'POST',
				dataType: 'json',
				success:function(data){
					alert(data.message);
					if(data.message=="success"){
						document.getElementById("blog").style.display="none";
						document.getElementById("publish").style.display="none";
						document.getElementById("uploadIndex").style.display="";
						document.getElementById("blog-title").disabled=true;
						document.getElementById("blog-author").disabled=true;
					}
				}
			});
			
		}
		
		function lxyIndexSubmit(){
			document.getElementById("hiddenTitle").value=document.getElementById("blog-title").value;
			var indexFile = document.getElementById("indexFile").value;
			if($.trim(indexFile)==""){
				alert("请添加封面文件");
				return ;
			}
			document.getElementById("uploadIndex").submit();
		}
	</script>
	
</body>
</html>

