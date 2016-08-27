<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>产品管理</title>
</head>

<body>
	<%@ include file="../layout/nav.jsp"%>

	<div class="section">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="../layout/sidebar.jsp"%>
			</div>
			<div class="col-md-9">
				<form action="" class="form-horizontal" role="form">
					<table class="table">
						<tbody>
							<tr>
								<td>
									<div class="form-group">
										<label for="nameId" class="col-sm-2 control-label">产品</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="nameId"
												name="name" placeholder="请输入产品名" value="${param.name }">
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="manifacturerId" class="col-sm-2 control-label">供应商</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="manufacturerId"
												name="manufacturer" placeholder="请输入供应商" value="${param.manufacturer}" >
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="priceMinId" class="col-sm-2 control-label">单价</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" id="priceMinId" 
												name="priceMin" placeholder="请输入单价" value="${param.priceMin}" />
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="priceMaxId" class="col-sm-2 control-label">至</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" id="priceMaxId" 
												name="priceMax" placeholder="请输入单价" value="${param.priceMax}" />
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
								<th>名称</th>
								<th>供应商</th>
								<th>单价(元)</th>
								<th>最低单价(元)</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty productArray}">
								<tr>
									<td colspan="5" align="center">暂无数据</td>
								</tr>
							</c:if>
							<c:forEach items="${productArray}" var="product">
								<tr>
									<td style="font-size: 150%">${product.name }</td>
									<td style="font-size: 150%">${product.manufacturer}</td>
									<td style="font-size: 150%">${product.price}</td>
									<td style="font-size: 150%">${product.priceLower }</td>
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
				<c:set var="searchParams" value="name=${param.name}&manufacturer=${param.manufacturer}&priceMin=${param.priceMin}&priceMax=${param.priceMax}" />
				<%@ include file="../layout/pager.jsp" %>
				<div class="section">
					<a class="btn btn-default btn-lg" href="/product/add">添加产品</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
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