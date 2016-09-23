<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<%-- <div class="span12">
	<div class="box-header">
		<ul class="lead nav nav-pills">
			<shiro:hasRole name="admin">
				<li><a href="/sale/list">列表详情</a></li>
				<li><a href="/sale/chart/general">销售曲线图</a></li>
				<li><a href="/sale/chart/product">产品购买图</a></li>
			</shiro:hasRole>
			<li><a href="/sale/chart/customer">客户购买图</a></li>
		</ul>
	</div>
</div> --%>

<ul class="breadcrumb lead nav nav-pills" style="background-color: #000000;opacity: 0.8">
	<shiro:hasRole name="admin">
		<li>
			<a href="/sale/list" style="color:#FFFFFF">列表详情</a>
		</li>
		<li>
			<a href="/sale/chart/general" style="color:#FFFFFF">销售曲线图</a>
		</li>
		<li>
			<a href="/sale/chart/product" style="color:#FFFFFF">产品购买图</a>
		</li>
	</shiro:hasRole>
	<li><a href="/sale/chart/customer" style="color:#FFFFFF">客户购买图</a></li>
</ul>