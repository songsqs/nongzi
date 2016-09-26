<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<script type="text/javascript" src="/resource/js/echarts/echarts.common.min.js"></script>

<title>销售管理</title>
</head>

<body>
	<%@ include file="../layout/sale_nav.jsp" %>
	<div class="box span12">
		<div class="box-header" data-origin-title>
			<h2>
				<i class="icon-bar-chart"></i>
				<span class="break"></span>
				客户购买图
			</h2>
		</div>
		<div class="box-content">
			<form action="">
				<div class="row-fluid">
					<shiro:hasRole name="admin">
					<div class="span4">
						<div class="dataaTables_filter" id="customerNameDiv">
							<label>
								姓名:
								<input type="text" aria-controls="customerNameDiv" name="customerName" 
									placeholder="客户姓名" value="${param.customerName }" />
							</label>
						</div>
					</div>
					</shiro:hasRole>
					<div class="span4">
						<div class="dataaTables_filter" id="timeBeginDiv">
							<label>
								时间:
								<input type="text" aria-controls="timeBeginDiv" name="timeBegin"
								 	id="timeBeginId" placeholder="起始时间" onfocus="this.blur()" value="${param.timeBegin }" />
							</label>
						</div>
					</div>
					<div class="span4">
						<div class="dataaTables_filter" id="timeEndDiv">
							<label>
								至
								<input type="text" aria-controls="timeEndDiv" name="timeEnd"
									id="timeEndId" placeholder="结束时间" onfocus="this.blur()" value="${param.timeEnd }" />
							</label>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<input type="submit" class="btn btn-primary" value="查询" />
				</div>
			</form>
		</div>
		<div class="box-content">
			<div class="row-fluid">
				<div class="box span12" id="customer_line_chart" style="height: 600px;">
				</div>
			</div>
		</div>
		<div class="box-content">
			<div class="row-fluid">
				<div class="box span12" id="customer_pie_chart" style="height: 600px;">
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

		//构建图表
		$(function() {
			//给予准备好的dom,初始化echarts实例
			var customerLineChart = echarts.init(document
					.getElementById('customer_line_chart'));
			//加载配置和数据
			var customerLineOption = ${customerLineOption};
			//使用指定的配置和数据显示图表
			customerLineChart.setOption(customerLineOption);

			var customerPieChart = echarts.init(document
					.getElementById('customer_pie_chart'));
			var customerPieOption = ${customerPieOption};
			customerPieChart.setOption(customerPieOption);

		});
	</script>
</body>
</html>