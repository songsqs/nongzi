<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<i class="icon-user"></i> <span class="break"></span> 添加客户
			</h2>
		</div>
		<div class="box-content">
			<form action="/customer/add.do" class="form-horizontal" method="post">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="nameId"> 姓名: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="name" id="nameId"
								placeholder="姓名">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="idNoId"> 身份证号: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="idNo" id="idNoId"
								placeholder="身份证号">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="mobileId"> 手机: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="mobile"
								id="mobileId" placeholder="强烈建议输入手机号,否则无法创建账户">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="birthdayId"> 生日: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="birthday"
								id="birthdayId" placeholder="生日" onfocus="this.blur()">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="provinceId"> 手机: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="province"
								id="provinceId" placeholder="省">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="provinceId"> 省: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="province"
								id="provinceId" placeholder="省">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="cityId"> 市: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="city" id="cityId"
								placeholder="市">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="districtId"> 区(乡): </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="district"
								id="districtId" placeholder="区(乡)">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="villageId"> 村: </label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="village"
								id="villageId" placeholder="村">
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary"
							onclick="return onSubmit()">确定</button>
						<a href="/customer/list">
							<button type="button" class="btn">取消</button>
						</a>
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
	</script>
</body>
</html>
