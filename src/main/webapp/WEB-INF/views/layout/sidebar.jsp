<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<ul class="lead nav nav-pills nav-stacked">
	<shiro:hasRole name="admin">
	<li><a href="/sale/list">销售列表</a></li>
	</shiro:hasRole>
	<shiro:hasRole name="normal">
	<li><a href="/sale/chart/customer">销售列表</a></li>
	</shiro:hasRole>
	<li><a href="/customer/list">客户管理</a></li>
	<li><a href="/product/list">产品管理</a></li>
</ul>
