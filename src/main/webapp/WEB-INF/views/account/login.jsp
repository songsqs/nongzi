<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>

		<meta name="viewport" content="width=device-width, initial-scale=1"/>

		<link id="bootstrap-style" href="/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<link href="/resource/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
		<link id="base-style" href="/resource/bootstrap/css/style.css" rel="stylesheet"/>
		<link id="base-style-responsive" href="/resource/bootstrap/css/style-responsive.css" rel="stylesheet"/>

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


		<title>用户登录</title>
	</head>
	<body style="background-image:url(/resource/images/common/harvest.jpg);background-position:center; background-size:cover">
		<div class="container-fluid-full">
			<div >
				<h1 align="center">风华农资超市</h1>
			</div>
			<div class="row-fluid">
				<div class="row-fluid">
					<div class="login-box">
						<div class="icons">
							<a href="#">
								<i class="halflings-icon home"></i>
							</a>
							<a href="#">
								<i class="halflings-icon cog"></i>
							</a>
						</div>
						<h2>请登录</h2>
						<form class="form-horizontal" role="form" action="/login" method="post">
							<fieldset>
								<div class="input-prepend" title="username">
									<span class="add-on">
										<i class="halflings-icon user"></i>
									</span>
									<input class="input-large span10" name="username" id="userNameId" type="text" placeholder="用户名"/>
								</div>
								<div class="input-prepend" title="password">
									<span class="add-on">
										<i class="halflings-icon lock"></i>
									</span>
									<input class="input-large span10" name="password" id="passwordId" type="password" placeholder="密码"/>
								</div>
								<div class="clearfix"></div>
								<label class="remember" for="remember"><input type="checkbox" id="remember" name="rememberMe"/>记住我</label>
								<div class="button-login">
									<button type="submit" class="btn btn-primary">登录</button>
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</body>
	</html>
