<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<title>销售管理</title>
</head>

<body>
	<%@ include file="../layout/sale_nav.jsp" %>
	<div class="span12">
		<div class="box-header" data-origin-title>
			<h2>
				<i class="icon-bar-chart"></i>
				<span class="break"></span>
				销售列表
			</h2>
		</div>
		<div class="box-content">
			<form action="" >
				<div class="row-fluid">
					<div class="span3">
						<div class="dataaTables_filter" id="customerNameDiv">
							<label>
								姓名:
								<input type="text" aria-controls="customerNameDiv" placeholder="姓名"
									name="customerName" value="${param.customerName }" />
							</label>
						</div>
					</div>
					<div class="span3">
						<div class="dataaTables_filter" id="productNameDiv">
							<label>
								产品:
								<input type="text" aria-controls="productNameDiv" placeholder="产品名"
									name="productName" value="${param.productName }" />
							</label>
						</div>
					</div>
					<div class="span3">
						<div class="dataaTables_filter" id="timeBeginDiv">
							<label>
								时间:
								<input type="text" aria-controls="timeBeginDiv" placeholder="起始时间"
									name="timeBegin" onfocus="this.blur()" id="timeBeginId" />
							</label>
						</div>
					</div>
					<div class="span3">
						<div class="dataaTables_filter" id="timeEndDiv">
							<label>
								至
								<input type="text" aria-controls="timeEndDiv" placeholder="结束时间"
									name="timeEnd" onfocus="this.blur()" id="timeEndId" />
							</label>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<input type="submit" class="btn btn-primary" value="查询" />
				</div>
			</form>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
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
					<c:if test="${empty saleList }">
						<tr>
							<td colspan="8" align="center">
								暂无数据
							</td>
						</tr>
					</c:if>
					<c:forEach items="${saleList }" var="sale">
						<tr>
							<td>${sale.productName }</td>
							<td>${sale.customerName }</td>
							<td>${sale.price }</td>
							<td>${sale.num }</td>
							<td>${sale.totalPrice }</td>
							<td>${sale.profit }</td>
							<td><fmt:formatDate value="${sale.createTime }" pattern="yyyy-MM-dd" /></td>
							<td>
								<a onclick="deleteProduct(${sale.saleId})" class="btn btn-primary">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:set var="searchParams" value="customerName=${param.customerName}&productName=${param.productName }&timeBegin=${param.timeBegin}&timeEnd=${param.timeEnd}"/>
			<%@ include file="../layout/pager.jsp" %>
			<div class="row-fluid">
				<a class="btn btn-primary btn-lg" href="/sale/add" >添加销售记录</a>
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

		function deleteProduct(saleIdParam) {
			if(confirm("确定删除选中的记录？")){
				$.ajax({
					type : "post",
					url : "/sale/delete.do",
					data : {
						saleId : saleIdParam
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
