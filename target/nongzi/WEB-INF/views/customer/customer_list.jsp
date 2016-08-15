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
<title>客户管理</title>
</head>

<body>
	<%@ include file="../layout/nav.jsp"%>

	<div class="section">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="../layout/sidebar.jsp"%>
			</div>
			<div class="col-md-9">
				<div class="container-fluid">
					<table class="table table-bordered">
						<thead>
							<tr class="success">
								<th>姓名</th>
								<th>身份证号</th>
								<th>手机</th>
								<th>生日</th>
								<th>省</th>
								<th>市</th>
								<th>区(乡)</th>
								<th>村</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty customerList}">
								<tr>
									<td colspan="8" align="center">暂无数据</td>
								</tr>
							</c:if>
							<c:forEach items="${customerList}" var="customer">
								<tr>
									<td style="font-size: 150%">${customer.name }</td>
									<td style="font-size: 150%">${customer.idNo}</td>
									<td style="font-size: 150%">${customer.mobile}</td>
									<td style="font-size: 150%"><fmt:formatDate
											value="${customer.birthday}" pattern="yyyy-MM-dd" /></td>
									<td style="font-size: 150%">${customer.province}</td>
									<td style="font-size: 150%">${customer.city}</td>
									<td style="font-size: 150%">${customer.district}</td>
									<td style="font-size: 150%">${customer.village}</td>
									<td>
										<div class="btn-group">
											<a href="/customer/edit?customerId=${customer.customerId }"
												class="btn btn-primary">编辑</a> <a
												onclick="deleteCustomer(${customer.customerId})"
												class="btn btn-primary">删除</a>
										</div>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<div class="section">
					<a class="btn btn-default btn-lg" href="/customer/add">添加客户</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function deleteCustomer(customerIdParam) {
			if(confirm("确定删除选中的客户？")){
				$.ajax({
					type : "post",
					url : "/customer/delete.do",
					data : {
						customerId : customerIdParam
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