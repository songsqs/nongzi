<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
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
 				产品购买图
 			</h2>
 		</div>
 		<div class="box-content">
 			<form action="">
 				<div class="row-fluid">
 					<div class="span4">
 						<div class="dataaTables_filter" id="productNameDiv">
 							<label>
 								产品:
 								<input type="text" aria-controls="productNameDiv" name="productName" 
 									placeholder="产品" value="${param.productName }" />
 							</label>
 						</div>
 					</div>
 					<div class="span4">
 						<div class="dataaTables_filter" id="timeBeginDiv">
 							<label>
 								时间:
 								<input type="text" aria-controls="timeBeginDiv" name="timeBegin"
 									placeholder="起始时间" id="timeBeginId" onfocus="this.blur()" value="${param.timeBegin }" />
 							</label>
 						</div>
 					</div>
 					<div class="span4">
 						<div class="dataaTables_filter" id="timeEndDiv">
 							<label>
 								至
 								<input type="text" aria-controls="timeEndDiv" name="timeEnd"
 									placeholder="结束时间" id="timeEndId" onfocus="this.blur()" value="${param.timeEnd }" />
 							</label>
 						</div>
 					</div>
 				</div>
 				<div class="row-fluid">
 					<input type="submit" class="btn btn-primary" value="查询"/>
 				</div>
 			</form>
 		</div>
 		<div class="box-content">
 			<div class="row-fluid">
 				<div class="box span12" id="product_line_chart" style="height:600px;">
 				</div>
 			</div>
 		</div>
 		<div class="box-content">
 			<div class="row-fluid">
 				<div class="box span12" id="product_pie_chart" style="height:600px;">
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
			var productLineChart = echarts.init(document
					.getElementById('product_line_chart'));
			//加载配置和数据
			var productLineOption = ${productLineOption};
			//使用指定的配置和数据显示图表
			productLineChart.setOption(productLineOption);

			var productPieChart = echarts.init(document
					.getElementById('product_pie_chart'));
			var productPieOption = ${productPieOption};
			productPieChart.setOption(productPieOption);

		});
	</script>
</body>
</html>