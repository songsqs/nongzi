<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<div>
	<ul class="lead nav nav-pills">
		<shiro:hasRole name="admin">
		<li><a href="/sale/list">列表详情</a></li>
		<li><a href="/sale/chart/general">销售曲线图</a></li>
		<li><a href="/sale/chart/product">产品购买图</a></li>
		</shiro:hasRole>
		<li><a href="/sale/chart/customer">客户购买图</a></li>
	</ul>
</div>