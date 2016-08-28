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
<script type="text/javascript"
	src="${ctx}/resource/js/echarts/echarts.common.min.js"></script>

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
				<%@ include file="../layout/sale_nav.jsp"%>
				<form action="" class="form-horizontal" role="form">
					<table class="table">
						<tbody>
							<tr>
								<td>
									<div class="form-group">
										<label for="productName" class="col-sm-2 control-label">产品</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="productNameId"
												name="productName" placeholder="请输入产品名" value="${param.productName}">
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="timeBeginId" class="col-sm-2 control-label">时间</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="timeBeginId"
												name="timeBegin" placeholder="请选择时间" onfocus=this.blur() value="${param.timeBegin}">
										</div>
									</div>
								</td>
								<td>
									<div class="form-group">
										<label for="timeEndId" class="col-sm-2 control-label">至</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="timeEndId"
												name="timeEnd" placeholder="请选择时间" onfocus=this.blur() value="${param.timeEnd}">
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
					<table style="width:100%">
							<tr>
								<td style="width:50%">
									<div id="product_line_chart" style="width: 100%; height: 600px;"></div>
								</td>
								<td style="width:50%">
									<div id="product_pie_chart" style="width: 100%; height: 600px"></div>
								</td>
							</tr>
					</table>
					<!-- 
					<div id="product_line_chart" style="width: 100%; height: 600px;"></div>
					<div id="product_pie_chart" style="width: 100%; height: 600px"></div>
					 -->
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
			var productLineOption = ${productLineOption}
			;
			//使用指定的配置和数据显示图表
			productLineChart.setOption(productLineOption);

			var productPieChart = echarts.init(document
					.getElementById('product_pie_chart'));
			var productPieOption = ${productPieOption}
			;
			productPieChart.setOption(productPieOption);

		});
	</script>
</body>
</html>