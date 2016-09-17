<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<title>销售管理</title>
	</head>

	<body>
		<table class="table">
			<tbody>
				<tr>
					<td>
						<div class="form-group form-horizontal">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" placeholder="请输入姓名以搜索" onInput="onCustomerInput(this.value)"/>
							</div>
						</div>
					</td>
					<td>
						<div class="form-group form-horizontal">
							<label class="col-sm-2 control-label">产品名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" placeholder="请输入产品名以搜索" onInput="onProductInput(this.value)"/>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<form class="form-horizontal" role="form" action="add.do" id="saleAddForm" method="post">
			<div class="form-group">
				<div class="col-sm-2">
					<label class="control-label">产品名称:</label>
				</div>
				<div class="col-sm-10">
					<input type="hidden" id="productIdId" name="productId"/>
					<input type="hidden" id="productNameId" name="productName"/>
					<select id="productSelect" class="form-control" onChange="onProductChange(this)">
						<option disabled selected>请选择产品</option>
						<c:forEach items="${productList}" var="product">
							<option value="${product.price }" id="${product.productId}" title=${product.priceLower}>${product.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-2">
					<label for="customerNameId" class="control-label">姓名:</label>
				</div>
				<div class="col-sm-10">
					<input type="hidden" id="customerIdId" name="customerId">
						<input type="hidden" class="form-control" id="customerNameId" name="customerName">
							<select id="customerSelect" class="form-control" onChange="onCustomerChange(this)">
								<option disabled selected>请选择客户</option>
								<c:forEach items="${customerList}" var="customer">
									<option value="${customer.name}" id="${customer.customerId}">${customer.name}-${customer.mobile}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="price" class="control-label">单价(元):</label>
						</div>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="priceId" placeholder="单价" name="price">
								<input type="hidden" id="priceLowerId"></div>
							</div>
							<div class="form-group">
								<div class="col-sm-2">
									<label for="numId" class="control-label">数量:</label>
								</div>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="numId" placeholder="数量" name="num" onInput="onNumInput()"></div>
								</div>
								<div class="form-group">
									<div class="col-sm-2">
										<label for="totalPriceId" class="control-label">总价(元):</label>
									</div>
									<div class="col-sm-10">
										<input type="number" class="form-control" id="totalPriceId" placeholder="总价" name="totalPrice" onInput="onTotalPriceInput()"></div>
									</div>
									<div class="form-group">
										<div class="col-sm-2">
											<label for="profitId" class="control-label">利润(元):</label>
										</div>
										<div class="col-sm-10">
											<input type="number" class="form-control" id="profitId" placeholder="利润" name="profit"></div>
										</div>
										<div class="form-group">
											<div class="col-sm-2">
												<label for="createTimeId" class="control-label">时间:</label>
											</div>
											<div class="col-sm-10">
												<input type="datetime" class="form-control" id="createTimeId" placeholder="销售时间" name="createTime" onfocus=this.blur()></div>
											</div>
											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10">
													<button type="button" class="btn btn-default" onclick="return onSubmit();">确定</button>
													<a href="/product/list">
														<button type="button" class="btn btn-default">取消</button>
													</a>
												</div>
											</div>
										</form>

										<script type="text/javascript">

											$('#createTimeId').datetimepicker({language: 'zh-CN', format: 'yyyy-mm-dd', minView: 2});

											function onProductInput(productName) {
												$.ajax({
													url: "/product/getProduct.do",
													type: "post",
													data: {
														"name": productName
													},
													cache: "false",
													success: function (data) {
														var jsonArray = jQuery.parseJSON(data);
														//操作产品下拉框
														var obj = $('#productSelect');
														obj.empty();

														$("<option></option>").attr('disabled', 'disabled').attr('selected', 'selected').text("请选择产品").appendTo(obj);

														$.each(jsonArray, function (index, json) {
															console.log("#" + index + ",json:" + json.name);
															$('<option></option>').attr('id', json.productId).val(json.price).text(json.name).appendTo(obj);
														});
													},
													error: function (suggestionRequest, textStatus, error) {
														alert(error);
													}
												});
											}

											function onCustomerInput(customerName) {
												$.ajax({
													url: "/customer/getCustomer.do",
													type: "post",
													data: {
														"name": customerName
													},
													cache: "false",
													success: function (data) {
														var jsonArray = jQuery.parseJSON(data);
														//操作客户下拉框
														var obj = $('#customerSelect');
														obj.empty();

														$("<option></option>").attr('disabled', 'disabled').attr('selected', 'selected').text("请选择客户").appendTo(obj);

														$.each(jsonArray, function (index, json) {
															console.log("#" + index + ",json:" + json.name);
															$('<option></option>').attr('id', json.customerId).val(json.name).text(json.name + '-' + json.mobile).appendTo(obj);
														});
													},
													error: function (suggestionRequest, textStatus, error) {
														alert(error);
													}
												});
											}

											function onProductChange(selectedItem) {
												productIdId.value = selectedItem.options[selectedItem.options.selectedIndex].id;
												//productNameId.vaule=selectedItem.options[selectedItem.options.selectedIndex].text;
												$('#productNameId').val(selectedItem.options[selectedItem.options.selectedIndex].text);
												priceId.value = selectedItem.options[selectedItem.options.selectedIndex].value;
												priceLowerId.value = selectedItem.options[selectedItem.options.selectedIndex].title;
											}

											function onCustomerChange(selectedItem) {
												customerIdId.value = selectedItem.options[selectedItem.options.selectedIndex].id;
												customerNameId.value = selectedItem.options[selectedItem.options.selectedIndex].value;
											}

											function onNumInput() {
												var price = $('#priceId').val();
												if (isNaN(price)) {
													return false;
												}

												var num = $('#numId').val();
												if (isNaN(num)) {
													return false;
												}

												var totalPrice = price * num;
												$('#totalPriceId').val(totalPrice);

												var priceLower = $("#priceLowerId").val();
												if (isNaN(priceLower)) {
													return false;
												}

												var profit = totalPrice - priceLower * num;
												$("#profitId").val(profit);
											}

											function onTotalPriceInput() {
												var totalPrice = $("#totalPriceId").val();
												if (isNaN(totalPrice)) {
													return false;
												}

												var num = $("#numId").val();
												if (isNaN(num)) {
													return false;
												}

												var priceLower = $("#priceLowerId").val();
												if (isNaN(priceLower)) {
													return false;
												}

												var profit = totalPrice - priceLower * num;
												$("#profitId").val(profit);
											}

											function onSubmit() {
												if (!checkAndGetSelectValue("productNameId", "产品名称不能为空", "0")) {
													return false;
												}
												if (!checkAndGetSelectValue("customerNameId", "姓名不能为空", "0")) {
													return false;
												}
												if (!checkAndGetSelectValue("priceId", "单价不能为空", "0") || !checkIsNaN("priceId", "单价必须是数字")) {
													return false;
												}
												if (!checkAndGetSelectValue("numId", "数量不能为空", "0") || !checkIsNaN("numId", "数量必须是数字")) {
													return false;
												}
												if (!checkAndGetSelectValue("totalPriceId", "总价不能为空", "0") || !checkIsNaN("totalPriceId", "总价必须为数字")) {
													return false;
												}
												if (!checkAndGetSelectValue("profitId", "利润不能为空", "0") || !checkIsNaN("profitId", "利润必须是数字")) {
													return false;
												}
												if (!checkAndGetSelectValue("createTimeId", "时间不能为空", "0")) {
													return false;
												}

												$.ajax({
													cache: false,
													type: "POST",
													url: "/sale/add.do",
													data: $('#saleAddForm').serialize(),
													success: function (data) {
														alert("添加成功,可以继续添加");
													},
													error: function (request) {
														alert("添加失败,如果多次失败请联系管理员");
													}
												});

												return true;
											}
										</script>
									</body>
								</html>
