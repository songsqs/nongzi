<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>客户管理</title>
</head>

<body>
	<div class="box span12">
		<div class="box-header" data-original-title>
			<h2>
				<i class="icon-user"></i> <span class="break"></span> 编辑客户信息
			</h2>
		</div>
		<div class="box-content">
			<form action="/customer/edit.do" class="form-horizontal"
				method="post">
				<fieldset>
					<input type="hidden" name="customerId" readonly
						value="${customer.customerId }">
					<div class="control-group">
						<label class="control-label" for="nameId"> 姓名: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="name" id="nameId"
								value="${customer.name }" placeholder="姓名">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="idNoId"> 身份证号: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="idNo" id="idNoId"
								placeholder="身份证号" value="${customr.idNo }">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="mobileId"> 手机: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="mobile"
								id="mobileId" placeholder="强烈建议输入手机号,否则无法创建账户"
								value="${customer.mobile }">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="birthdayId"> 生日: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="birthday"
								id="birthdayId" placeholder="生日" onfocus="this.blur()"
								value="${customer.birthday }">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="provinceId"> 省: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="province"
								id="provinceId" placeholder="省" value="${customer.province }">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="cityId"> 市: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="city" id="cityId"
								placeholder="市" value="${customer.city }">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="districtId"> 区(乡): </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="district"
								id="districtId" placeholder="区(乡)" value="${customer.district }">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="villageId"> 村: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="village"
								id="villageId" placeholder="村" value="${customer.village }">
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" onclick="return onSubmit()"
							class="btn btn-primary">确定</button>
						<shiro:hasRole name="admin">
							<c:if test="${customer.hasAccount}">
								<input type="button" value="重置密码" class="btn btn-primary"
									onclick="resetPassword(${customer.customerId})">
							</c:if>
							<c:if test="${!customer.hasAccount }">
								<input type="button" value="创建账户" class="btn btn-primary"
									onclick="createCustomerAccount(${customer.customerId})">
							</c:if>
							<a href="/customer/list">
								<button type="button" class="btn">取消</button>
							</a>
						</shiro:hasRole>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$('#birthdayId').datetimepicker({
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			minView : 2
		});

		function onSubmit() {
			if (!checkAndGetSelectValue("nameId", "姓名不能为空", "0")) {
				return false;
			}

			return true;
		}

		function resetPassword(customerIdParam) {
			$.ajax({
				type : "post",
				url : "/account/resetPassword.do",
				data : {
					customerId : customerIdParam
				},
				success : function(msg) {
					if ("success" == msg) {
						alert("操作成功！");
						window.location.reload();
					} else {
						alert("操作失败,如果多次失败,请联系管理员");
						window.location.reload();
					}
				},
				error : function(msg) {
					alert("操作失败,如果多次失败,请联系管理员");
					window.location.reload();
				}
			});
		}

		function createCustomerAccount(customerIdParam) {
			$.ajax({
				type : "post",
				url : "/account/createCustomerAccount.do",
				data : {
					customerId : customerIdParam
				},
				success : function(msg) {
					if ("success" == msg) {
						alert("操作成功！");
						window.location.reload();
					} else {
						alert("操作失败,如果多次失败,请联系管理员");
						window.location.reload();
					}
				},
				error : function(msg) {
					alert("操作失败,如果多次失败,请联系管理员");
				}
			});
		}
	</script>
</body>
</html>
