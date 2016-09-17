<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
			<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
				<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
				<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
				<script src="${ctx}/resource/js/myScript.js" type="text/javascript"></script>
				<title>产品管理</title>

				<body>
					<form class="form-horizontal" role="form" action="add.do" method="post">
						<div class="form-group">
							<div class="col-sm-2">
								<label for="name" class="control-label">产品名称:</label>
							</div>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="nameId" placeholder=产品名称 name="name" value="${product.name }"></div>
							</div>
							<div class="form-group">
								<div class="col-sm-2">
									<label for="manufacturer" class="control-label">制造商:</label>
								</div>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="manufacturerId" placeholder="制造商" name="manufacturer" value="${product.manufacturer }"></div>
								</div>
								<div class="form-group">
									<div class="col-sm-2">
										<label for="price" class="control-label">价格(元):</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="priceId" placeholder="价格" name="price" value="${product.price }"></div>
									</div>
									<div class="form-group">
										<div class="col-sm-2">
											<label for="priceLower" class="control-label">最低价格(元):</label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="priceLowerId" placeholder="最低价格" name="priceLower" value="${product.priceLower }"></div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-default" onclick="return onSubmit();">确定</button>
												<a href="/product/list">
													<button type="button" class="btn btn-default">取消</button>
												</a>
											</div>
										</div>
									</form>

									<script type="text/javascript">
										function onSubmit() {
											if (!checkAndGetSelectValue("nameId", "产品名称不能为空", "0")) {
												return false;
											}
											if (!checkAndGetSelectValue("manufacturerId", "制造商不能为空", "0")) {
												return false;
											}
											if (!checkAndGetSelectValue("priceId", "单价不能为空", "0") || !checkIsNaN("priceId", "单价必须是数字")) {
												return false;
											}
											if (!checkAndGetSelectValue("priceLowerId", "最低单价不能为空", "0") || !checkIsNaN("priceLowerId", "最低单价必须是数字")) {
												return false;
											}

											return true;
										}
									</script>
								</body>
							</html>
