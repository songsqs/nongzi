<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<title>客户管理</title>
</head>

<body>
	<div class="box-span12" style="opacity: 1.0">
		<div class="box-header" data-original-title>
			<h2>
				<i class="icon-user"></i> <span class="break"></span> 客户列表
			</h2>
		</div>
		<div class="box-content">
			<form action="">
				<div class="row-fluid">
					<div class="span4">
						<div class="dataaTables_filter" id="nameDiv">
							<label> 姓名: <input type="text" aria-controls="nameDiv"
								placeholder="姓名" name="name" value="${param.name }">
							</label>
						</div>
					</div>
					<div class="span4">
						<div class="dataaTables_filter" id="mobileDiv">
							<label> 手机: <input type="tel" aria-controls="mobileDiv"
								placeholder="手机" name="mobile" value="${param.mobile }">
							</label>
						</div>
					</div>
					<div class="span4">
						<div class="dataaTables_filter" id="villageDiv">
							<label> 村: <input type="text" aria-controls="villageDiv"
								placeholder="村" name="village" value="${param.village }">
							</label>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<input class="btn btn-primary" type="submit" value="查询" />
				</div>
			</form>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
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
							<td>${customer.name }</td>
							<td>${customer.idNo}</td>
							<td>${customer.mobile}</td>
							<td><fmt:formatDate value="${customer.birthday}"
									pattern="yyyy-MM-dd" /></td>
							<td>${customer.province}</td>
							<td>${customer.city}</td>
							<td>${customer.district}</td>
							<td>${customer.village}</td>
							<shiro:hasRole name="admin">
								<td>
									<div class="btn-group">
										<a href="/customer/edit?customerId=${customer.customerId }"
											class="btn btn-primary">编辑</a> <a
											onclick="deleteCustomer(${customer.customerId})"
											class="btn btn-primary">删除</a>
										<c:if test="${!customer.hasAccount}">
											<a class="btn btn-primary"
												onclick="createAccountForCustomer(${customer.customerId})">创建账户</a>
										</c:if>
									</div>
								</td>
							</shiro:hasRole>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:set var="searchParams"
				value="name=${param.name}&mobile=${param.mobile}&village=${param.village}" />
			<%@ include file="../layout/pager.jsp"%>
			<shiro:hasRole name="admin">
				<div class="row-fluid">
					<a class="btn btn-primary btn-lg" href="/customer/add">添加客户</a>
				</div>
			</shiro:hasRole>
		</div>
	</div>

	<script type="text/javascript">
					function deleteCustomer(customerIdParam) {
						if (confirm("确定删除选中的客户？")) {
							$.ajax({
								type: "post",
								url: "/customer/delete.do",
								data: {
									customerId: customerIdParam
								},
								success: function (msg) {
									//对返回结果进行处理
									alert("修改成功");
									window.location.reload();
								}
							});
						} else {
							return false;
						}
					}

					function createAccountForCustomer(customerIdParam) {
						if (confirm("确定为选定的客户创建帐号？")) {
							$.ajax({
								type: "post",
								url: "/account/createCustomerAccount.do",
								data: {
									customerId: customerIdParam
								},
								success: function (msg) {
									//对返回结果进行处理
									alert("创建账户成功");
									window.location.reload();
								},
								error: function (msg) {
									//对返回结果进行处理
									alert("创建账户失败,如果多次失败，请与管理员联系");
									window.location.reload();
								}
							});
						} else {
							return false;
						}
					}
				</script>
</body>
</html>
