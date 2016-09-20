<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>产品管理</title>
</head>
<body>
	<div class="box span12">
		<div class="box-header" data-original-title>
			<h2>
				<i class="halflings-icon edit"></i> 
				<span class="break"></span> 
				添加产品
			</h2>
		</div>
		<div class="box-content">
			<form action="/product/add.do" class="form-horizontal" method="post">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="nameId">
							产品名称:
						</label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="name" id="nameId">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="manufacturerId">
							制造商:
						</label>
						<div class="controls">
							<input type="text" class="input-xlarge" name="manufacturer" id="manufacturerId" >
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="priceId">
							单价(元):
						</label>
						<div class="controls">
							<input type="number" class="input-xlarge" name="price" id="priceId">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="priceLowerId">
							最低价格(元):
						</label>
						<div class="controls">
							<input type="number" class="input-xlarge" name="priceLower" id="priceLowerId" >
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary" onclick="return onSubmit()">确定</button>
						<a href="/product/list">
							<button type="button" class="btn">取消</button>
						</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function onSubmit() {
			if (!checkAndGetSelectValue("nameId", "产品名称不能为空", "0")) {
				return false;
			}
			if (!checkAndGetSelectValue("manufacturerId", "制造商不能为空", "0")) {
				return false;
			}
			if (!checkAndGetSelectValue("priceId", "单价不能为空", "0")
					|| !checkIsNaN("priceId", "单价必须是数字")) {
				return false;
			}
			if (!checkAndGetSelectValue("priceLowerId", "最低单价不能为空", "0")
					|| !checkIsNaN("priceLowerId", "最低单价必须是数字")) {
				return false;
			}

			return true;
		}
	</script>
</body>
</html>
