<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="${ctx}/resource/js/bootstrap-datetimepicker.min.js"
	type="text/javascript" charset="UTF-8"></script>
<script
	src="${ctx}/resource/js/locales/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="UTF-8"></script>
<script src="${ctx}/resource/js/myScript.js" type="text/javascript"></script>

<!-- jquery.ui -->
<!-- <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script> -->
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<title>销售管理</title>

<body>
	<%@ include file="../layout/nav.jsp"%>

	<div class="section">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="../layout/sidebar.jsp"%>
			</div>
			<div class="col-md-9">
				<form class="form-horizontal" role="form" action="add.do"
					method="post">
					<div class="form-group">
						<div class="col-sm-2">
							<label for="productNameId" class="control-label">产品名称:</label>
						</div>
						<div class="col-sm-10">
							<input type="hidden" id="productIdId" name="productId"> 
							<input type="text" class="form-control" id="productNameId"
								placeholder=产品名称 name="productName">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="customerNameId" class="control-label">制造商:</label>
						</div>
						<div class="col-sm-10">
							<input type="hidden" id="customerIdId" name="customerId">
							<input type="text" class="form-control" id="customerNameId"
								placeholder="姓名" name="customerName">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="price" class="control-label">单价(元):</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="priceId"
								placeholder="单价" name="price">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="numId" class="control-label">数量:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="numId"
								placeholder="数量" name="nums">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="totalPriceId" class="control-label">总价(元):</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="totalPriceId"
								placeholder="总价" name="totalPrice">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="profitId" class="control-label">利润(元):</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="profitId"
								placeholder="利润" name="profit">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="createTimeId" class="control-label">时间:</label>
						</div>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="createTimeId"
								placeholder="销售时间" name="createTime" readonly>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default"
								onclick="return onSubmit();">确定</button>
							<a href="/product/list">
								<button type="button" class="btn btn-default">取消</button>
							</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			//产品名
			$('#productNameId').autocomplete(
							{
								source : function(request, reponse) {
									$
											.ajax({
												contentType : "application/x-www-form-urlencoded; charset=utf-8",
												url : "/product/getProduct.do",
												type : "post",
												data : {
													"name" : $("#productNameId").val()
												},
												cache : "false",
												success : function(data) {
													console.log(data);
													var jsonData = jQuery
															.parseJSON(data);
													console.log(jsonData);
													reponse($
															.map(
																	jsonData,
																	function(
																			item) {
																		return {
																			label : item.name,
																			value : item.name,
																			id : item.productId
																		}
																	}));
												},
												error : function(
														suggestionRequest,
														textStatus, error) {
													alert(error);
												}
											})
								},
								minChars : 0,
								max : 10,
								autoFill : false,
								scollHeight : 200,
								select : function(event, ui) {
									$("#productIdId").val(ui.item.id);
									$("#productNameId").val(ui.item.value);
									return false;
								}
							});
			//客户姓名
			$('customerNameId').autocomplete(
							{
								source : function(request, reponse) {
									$
											.ajax({
												url : "/customer/getCustomer.do",
												type : "post",
												data : {
													"name" : $("#customerNameId").val()
												},
												cache : "false",
												success : function(data) {
													console.log(data);
													var jsonData = jQuery
															.parseJSON(data);
													console.log(jsonData);
													reponse($
															.map(
																	jsonData,
																	function(
																			item) {
																		return {
																			label : item.name,
																			value : item.name,
																			id : item.customerId
																		}
																	}));
												},
												error : function(
														suggestionRequest,
														textStatus, error) {
													alert(error);
												}
											})
								},
								minChars : 0,
								max : 10,
								autoFill : false,
								scollHeight : 200,
								select : function(event, ui) {
									$("#customerIdId").val(ui.item.id);
									$("#customerNameId").val(ui.item.value);
									return false;
								}
							});
		});

		$('#createTimeId').datetimepicker({
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			minView : 2,
		});

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