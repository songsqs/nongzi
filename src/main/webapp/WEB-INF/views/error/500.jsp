<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>500 - 系统内部错误</title>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-500-full-page">
	<div class="row">
		<div class="col-md-12 page-500">
			<div class=" number">
				500
			</div>
			<div class=" details">
				<h3>系统发生内部错误.</h3>
				<p>
					<a href="<c:url value="/"/>">返回首页</a><br/>
				</p>
			</div>
		</div>
	</div>
</body>
<!-- END BODY -->
</html>