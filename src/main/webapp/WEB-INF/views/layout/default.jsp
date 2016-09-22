<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link id="bootstrap-style" href="/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/resource/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="/resource/bootstrap/css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="/resource/bootstrap/css/style-responsive.css" rel="stylesheet">

<script src="/resource/js/myScript.js" type="text/javascript"></script>

<!-- start: JavaScript-->
<script src="/resource/bootstrap/js/jquery-1.9.1.min.js"></script>
<script src="/resource/bootstrap/js/jquery-migrate-1.0.0.min.js"></script>
<script src="/resource/bootstrap/js/jquery-ui-1.10.0.custom.min.js"></script>
<script src="/resource/bootstrap/js/jquery.ui.touch-punch.js"></script>
<script src="/resource/bootstrap/js/modernizr.js"></script>
<script src="/resource/bootstrap/js/bootstrap.min.js"></script>
<script src="/resource/bootstrap/js/jquery.cookie.js"></script>
<script src='/resource/bootstrap/js/fullcalendar.min.js'></script>
<script src='/resource/bootstrap/js/jquery.dataTables.min.js'></script>
<script src="/resource/bootstrap/js/excanvas.js"></script>
<script src="/resource/bootstrap/js/jquery.flot.js"></script>
<script src="/resource/bootstrap/js/jquery.flot.pie.js"></script>
<script src="/resource/bootstrap/js/jquery.flot.stack.js"></script>
<script src="/resource/bootstrap/js/jquery.flot.resize.min.js"></script>
<script src="/resource/bootstrap/js/jquery.chosen.min.js"></script>
<script src="/resource/bootstrap/js/jquery.uniform.min.js"></script>
<script src="/resource/bootstrap/js/jquery.cleditor.min.js"></script>
<script src="/resource/bootstrap/js/jquery.noty.js"></script>
<script src="/resource/bootstrap/js/jquery.elfinder.min.js"></script>
<script src="/resource/bootstrap/js/jquery.raty.min.js"></script>
<script src="/resource/bootstrap/js/jquery.iphone.toggle.js"></script>
<script src="/resource/bootstrap/js/jquery.uploadify-3.1.min.js"></script>
<script src="/resource/bootstrap/js/jquery.gritter.min.js"></script>
<script src="/resource/bootstrap/js/jquery.imagesloaded.js"></script>
<script src="/resource/bootstrap/js/jquery.masonry.min.js"></script>
<script src="/resource/bootstrap/js/jquery.knob.modified.js"></script>
<script src="/resource/bootstrap/js/jquery.sparkline.min.js"></script>
<script src="/resource/bootstrap/js/counter.js"></script>
<script src="/resource/bootstrap/js/retina.js"></script>
<script src="/resource/bootstrap/js/custom.js"></script>
<!-- end: JavaScript-->
<!-- datetimepicker -->
<script src="/resource/js/bootstrap-datetimepicker.min.js"
	type="text/javascript" charset="UTF-8"></script>
<script
	src="/resource/js/locales/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="UTF-8"></script>
<!--datetimepicker end -->

<title><sitemesh:title/></title>
</head>

<body style="background-image:url(/resource/images/common/harvest.jpg);background-position:center; background-size:cover">
	<!-- top bar -->
	<%@ include file="nav.jsp"%>
	<!-- top bar end-->

	<div class="container-fluid-full">
		<div class="row-fluid">
			<!-- sidebar -->
			<div id="sidebar-left" class="span2" style="background-color:rgba(0,0,0,0.7)">
				<%@ include file="sidebar.jsp" %>
			</div>
			<!-- sidebar end -->

			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">警告!</h4>
					<p>您的浏览器不支持 <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>.</p>
				</div>
			</noscript>

			<!--content -->
			<div id="content" class="span10" style="background-color:rgba(255,255,255,0)">
				<sitemesh:body/>
			</div>
			<!--content end -->

		</div>
	</div>
</body>
</html>
