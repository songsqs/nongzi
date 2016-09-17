<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<div class="nav-collapse sidebar-nav">
	<ul class="nav nav-tabs nav-stacked main-menu">
		<shiro:hasRole name="admin">
			<li>
				<a href="/sale/list">
					<i class="icon-bar-chart"></i>
					<span class="hidden-tablet">
						销售列表
					</sapn>
				</a>
			</li>
		</shiro:hasRole>
		<shiro:hasRole name="normal">
			<li>
				<a href="/sale/chart/customer">
					<i class="icon-bar-chart"></i>
					<span class="hidden-tablet">
						销售列表
					</sapn>
				</a>
			</li>
		</shiro:hasRole>
		<li>
			<a href="/customer/list">
				<i class="icon-user"></i>
				<span class="hidden-tablet">
					客户管理
				</span>
			</a>
		</li>
		<li>
			<a href="/product/list">
				<i class="icon-shopping-cart"></i>
				<span class="hidden-tablet">
					产品管理
				</sapn>
			</a>
		</li>
	</ul>
</div>
