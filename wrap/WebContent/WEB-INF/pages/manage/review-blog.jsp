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
<script src="resources/js/tinymce/tinymce.min.js"></script>
<style>

.container .info {
	position: absolute;
	left: 100px;
	top: 150px;
	border: 1px solid;
	border-color: #e6e0e0;
	padding: 50px 100px;
}

.container .info .title{
	font-size: 30px;
}
</style>

</head>

<body>
	<%@include file="/WEB-INF/pages/common/header-manage.jsp" %>
	<div class="container">
		<div class="info">
			 <span id="title">文章标题：</span><input type="text" />
			 <textarea id="myTextarea"></textarea>
			 <input type="button" value="发布文章"/>
		</div>
	</div>
	<%@include file="/WEB-INF/pages/common/footer.jsp" %>
	
	<script>
		function onLoad(){
			tinymce.init({
			    selector: '#myTextarea',
			    theme: 'modern',
			    width: 1000,
			    height: 500,
			    plugins: [
			      'advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker',
			      'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
			      'save table contextmenu directionality emoticons template paste textcolor'
			    ],
			    content_css: 'css/content.css',
			    toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons | fontselect | fontsizeselect',
			    language:'zh_CN'
			  });
		}
	</script>
	
</body>
</html>

