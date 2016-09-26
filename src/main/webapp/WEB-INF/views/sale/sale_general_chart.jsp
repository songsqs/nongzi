<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<html>
<head>

<script type="text/javascript" src="/resource/js/echarts/echarts.common.min.js"></script>

<title>销售管理</title>
</head>

<body>
 	<%@ include file="../layout/sale_nav.jsp" %>
 	<div class="span12">
 		<div class="box-header" data-origin-title>
 			<h2>
 				<i class="icon-bar-chart"></i>
				<span class="break"></span>
				销售曲线图
 			</h2>
 		</div>
 		<div class="box-content">
 			<form action="">
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
									name="timeBegin" onfocus="this.blur()" id="timeBeginId" value="${param.timeBegin }" />
							</label>
						</div>
					</div>
					<div class="span3">
						<div class="dataaTables_filter" id="timeEndDiv">
							<label>
								至
								<input type="text" aria-controls="timeEndDiv" placeholder="结束时间"
									name="timeEnd" onfocus="this.blur()" id="timeEndId" value="${param.timeEnd }" />
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
 				<div class="box span12">
	 				<div id="general_sale_chart" style="width:100%;height:600px"></div>
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
		$(function(){
			//给予准备好的dom,初始化echarts实例
			var saleChart=echarts.init(document.getElementById('general_sale_chart'));
			
			//加载配置和数据
			var option = ${option};
			
			//使用指定的配置和数据显示图表
			saleChart.setOption(option);
		});
	</script>
</body>
</html>