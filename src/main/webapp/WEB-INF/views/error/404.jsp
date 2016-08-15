<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%response.setStatus(200);%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>404 - 页面不存在</title>
</head>
<!-- BEGIN BODY -->
<body class="page-404-full-page">
	<div class="row">
		<div class="col-md-12 page-404">
			<div class="number">
				404
			</div>
			<div class="details">
				<h3>页面不存在.</h3>
				<p>
					<a href="<c:url value="/"/>">返回首页</a> 
				</p>
			</div>
		</div>
	</div>
</body>
<!-- END BODY -->
</html>