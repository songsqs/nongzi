<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<title>客户管理</title>
	</head>

	<body>
<!-- 
		<form class="form-horizontal" role="form" action="edit.do" method="post">
			<div class="form-group">
				<div class="col-sm-2">
					<label for="name" class="control-label">姓名:</label>
				</div>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nameId" placeholder=姓名 name="name" value="${customer.name }"></div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label for="manufacturer" class="control-label">身份证号:</label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="idNoId" placeholder="强烈建议输入身份证号,以区分不同客户" name="idNo" value="${customer.idNo}"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="price" class="control-label">手机:</label>
						</div>
						<div class="col-sm-10"><input type="text" class="form-control" id="mobileId" placeholder="手机" name="mobile" value="${customer.mobile }" <shiro:hasRole name="normal">readonly</shiro:hasRole>
						>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label for="priceLower" class="control-label">生日:</label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="birthdayId" placeholder="生日" name="birthday" value="${birthday }" onfocus=this.blur()></div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="priceLower" class="control-label">省:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="provinceId" placeholder="省" name="province" value="${customer.province }"></div>
						</div>
						<div class="form-group">
							<div class="col-sm-2">
								<label for="priceLower" class="control-label">市:</label>
							</div>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="cityId" placeholder="市" name="city" value="${customer.city }"></div>
							</div>
							<div class="form-group">
								<div class="col-sm-2">
									<label for="priceLower" class="control-label">区(乡):</label>
								</div>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="districtId" placeholder="区(乡)" name="district" value="${customer.district }"></div>
								</div>
								<div class="form-group">
									<div class="col-sm-2">
										<label for="priceLower" class="control-label">村:</label>
									</div>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="villageId" placeholder="村" name="village" value="${customer.village }"></div>
									</div>
									<input type="hidden" name="customerId" value="${customer.customerId }"/>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-default" onclick="return onSubmit();">确定</button>
											<shiro:hasRole name="admin">
												<c:if test="${customer.hasAccount}">
													<input type="button" value="重置密码" class="btn btn-default" onclick="resetPassword(${customer.customerId})"></c:if>
													<c:if test="${!customer.hasAccount}">
														<input type="button" value="创建账户" class="btn btn-default" onclick="createCustomerAccount(${customer.customerId})"></c:if>
													</shiro:hasRole>
													<a href="/customer/list">
														<button type="button" class="btn btn-default">取消</button>
													</a>
												</div>
											</div>
										</form>
 -->
 		<div class="box span12">
 			<div class="box-header" data-original-title>
 				<h2>
 					<i class="icon-user"></i>
 					<span class="break"></span>
 					编辑客户信息
 				</h2>
 			</div>
 			<div class="box-content">
 			</div>
 		</div>
										<script type="text/javascript">
											$('#birthdayId').datetimepicker({language: 'zh-CN', format: 'yyyy-mm-dd', minView: 2});

											function onSubmit() {
												if (!checkAndGetSelectValue("nameId", "姓名不能为空", "0")) {
													return false;
												}

												return true;
											}

											function resetPassword(customerIdParam) {
												$.ajax({
													type: "post",
													url: "/account/resetPassword.do",
													data: {
														customerId: customerIdParam
													},
													success: function (msg) {
														if ("success" == msg) {
															alert("操作成功！");
															window.location.reload();
														} else {
															alert("操作失败,如果多次失败,请联系管理员");
															window.location.reload();
														}
													},
													error: function (msg) {
														alert("操作失败,如果多次失败,请联系管理员");
														window.location.reload();
													}
												});
											}

											function createCustomerAccount(customerIdParam) {
												$.ajax({
													type: "post",
													url: "/account/createCustomerAccount.do",
													data: {
														customerId: customerIdParam
													},
													success: function (msg) {
														if ("success" == msg) {
															alert("操作成功！");
															window.location.reload();
														} else {
															alert("操作失败,如果多次失败,请联系管理员");
															window.location.reload();
														}
													},
													error: function (msg) {
														alert("操作失败,如果多次失败,请联系管理员");
													}
												});
											}
										</script>
									</body>
								</html>
