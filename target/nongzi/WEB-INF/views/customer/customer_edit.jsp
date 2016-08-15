<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ctx}/resource/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="${ctx}/resource/js/myScript.js" type="text/javascript"></script>
<script src="${ctx}/resource/js/bootstrap-datetimepicker.min.js"
	type="text/javascript" charset="UTF-8"></script>
<script
	src="${ctx}/resource/js/locales/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="UTF-8"></script>

<title>客户管理</title>

<body>

	<%@ include file="../layout/nav.jsp"%>

	<div class="section">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="../layout/sidebar.jsp"%>
			</div>
			<div class="col-md-9">
				<form class="form-horizontal" role="form" action="edit.do"
					method="post">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="name" class="control-label">姓名:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nameId"
								placeholder=姓名 name="name" value="${customer.name }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="manufacturer" class="control-label">身份证号:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="idNoId"
								placeholder="强烈建议输入身份证号,以区分不同客户" name="idNo"
								value="${customer.idNo}">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="price" class="control-label">手机:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mobileId"
								placeholder="手机" name="mobile" value="${customer.mobile }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="priceLower" class="control-label">生日:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="birthdayId"
								placeholder="生日" name="birthday" readonly value="${birthday }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="priceLower" class="control-label">省:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="provinceId"
								placeholder="省" name="province" value="${customer.province }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="priceLower" class="control-label">市:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="cityId"
								placeholder="市" name="city" value="${customer.city }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="priceLower" class="control-label">区(乡):</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="districtId"
								placeholder="区(乡)" name="district" value="${customer.district }">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="priceLower" class="control-label">村:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="villageId"
								placeholder="村" name="village" value="${customer.village }">
						</div>
					</div>
					<input type="hidden" name="customerId"
						value="${customer.customerId }" />
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default"
								onclick="return onSubmit();">确定</button>
							<a href="/customer/list">
								<button type="button" class="btn btn-default">取消</button>
							</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#birthdayId').datetimepicker({
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			minView : 2,
		});

		function onSubmit() {
			if (!checkAndGetSelectValue("nameId", "姓名不能为空", "0")) {
				return false;
			}

			return true;
		}
	</script>
</body>
</html>