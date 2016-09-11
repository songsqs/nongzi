<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

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
				<form action="" class="form-horizontal" role="form">
					<table class="table">
						<tbody>
							<tr>
								<td>
									<div class="form-group">
										<label for="nameId" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="nameId"
												name="name" placeholder="请输入姓名" value="${param.name }">
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="mobileId" class="col-sm-2 control-label">手机</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" id="mobileId"
												name="mobile" placeholder="请输入手机" value="${param.mobile}" >
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="villageId" class="col-sm-2 control-label">村</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="villageId" 
												name="village" placeholder="请输入村" value="${param.village}" />
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
								<th>姓名</th>
								<th>身份证号</th>
								<th>手机</th>
								<th>生日</th>
								<th>省</th>
								<th>市</th>
								<th>区(乡)</th>
								<th>村</th>
								<shiro:hasRole name="admin">
								<th>操作</th>
								</shiro:hasRole>
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
									<shiro:hasRole name="admin">
									<td>
										<div class="btn-group">
											<a href="/customer/edit?customerId=${customer.customerId }"
												class="btn btn-primary">编辑</a> <a
												onclick="deleteCustomer(${customer.customerId})"
												class="btn btn-primary">删除</a>
										</div>
									</td>
									</shiro:hasRole>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<c:set var="searchParams" value="name=${param.name}&mobile=${param.mobile}&village=${param.village}" />
				<%@ include file="../layout/pager.jsp" %>
				<shiro:hasRole name="admin">
				<div class="section">
					<a class="btn btn-default btn-lg" href="/customer/add">添加客户</a>
				</div>
				</shiro:hasRole>
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