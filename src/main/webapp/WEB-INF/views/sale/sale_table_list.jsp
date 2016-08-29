<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<script src="${ctx}/resource/js/bootstrap-datetimepicker.min.js"
	type="text/javascript" charset="UTF-8"></script>
<script
	src="${ctx}/resource/js/locales/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="UTF-8"></script>

<title>销售管理</title>
</head>

<body>
	<%@ include file="../layout/nav.jsp"%>

	<div class="section">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="../layout/sidebar.jsp"%>
			</div>
			<div class="col-md-9">
				<%@ include file="../layout/sale_nav.jsp" %>
				<form action="" class="form-horizontal" role="form">
					<table class="table">
						<tbody>
							<tr>
								<td>
									<div class="form-group">
										<label for="customerName" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="customerNameId"
												name="customerName" placeholder="请输入姓名" value="${param.customerName}">
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="productName" class="col-sm-2 control-label">产品</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="productNameId"
												name="productName" placeholder="请输入产品名" value="${param.productName }">
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="timeBeginId" class="col-sm-2 control-label">时间</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="timeBeginId"
												name="timeBegin" placeholder="请选择时间" onfocus=this.blur() value="${param.timeBegin }">
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="timeEndId" class="col-sm-2 control-label">至</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="timeEndId"
												name="timeEnd" placeholder="请选择时间" onfocus=this.blur() value="${param.timeEnd }">
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<div class="form-group">
										<input class="btn btn-default" type="submit" value="查询" />
									</div>
								</td>
							</tr>
						</tbody>
					</table>

				</form>
				<div class="container-fluid">
					<table class="table table-bordered">
						<thead>
							<tr class="success">
								<th>产品</th>
								<th>姓名</th>
								<th>单价(元)</th>
								<th>数量</th>
								<th>总价(元)</th>
								<th>利润(元)</th>
								<th>销售时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty saleList}">
								<tr>
									<td colspan="8" align="center">
										暂无数据
									</td>
								</tr>
							</c:if>
							<c:forEach items="${saleList}" var="sale">
								<tr>
									<td style="font-size: 150%">${sale.productName }</td>
									<td style="font-size: 150%">${sale.customerName}</td>
									<td style="font-size: 150%">${sale.price}</td>
									<td style="font-size: 150%">${sale.num}</td>
									<td style="font-size: 150%">${sale.totalPrice}</td>
									<td style="font-size: 150%">${sale.profit}</td>
									<td style="font-size: 150%"><fmt:formatDate
											value="${sale.createTime}" pattern="yyyy-MM-dd" /></td>
									<td>
										<div class="btn-group">
											<a href="/product/edit?productId=${product.productId }"
												class="btn btn-primary">编辑</a> <a
												onclick="deleteProduct(${product.productId})"
												class="btn btn-primary">删除</a>
										</div>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<c:set var="searchParams" value="customerName=${param.customerName}&productName=${param.productName }&timeBegin=${param.timeBegin}&timeEnd=${param.timeEnd}" />
				<%@ include file="../layout/pager.jsp" %>
				<div class="section">
					<a class="btn btn-default btn-lg" href="/sale/add">添加销售记录</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#timeBeginId').datetimepicker({
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			minView : 2,
		});
		
		$('#timeEndId').datetimepicker({
			language : 'zh-CN',
			format : 'yyyy-mm-dd',
			minView : 2,
		});
	
		function deleteProduct(productIdParam) {
			if(confirm("确定删除选中的产品？")){
				$.ajax({
					type : "post",
					url : "/product/delete.do",
					data : {
						productId : productIdParam
					},
					success : function(msg) {
						//对返回结果进行处理
						alert("修改成功");
						window.location.reload();
					}
				});
			}else{
				return false;
			}
		}
	</script>
</body>
</html>