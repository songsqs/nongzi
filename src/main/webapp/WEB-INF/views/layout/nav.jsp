<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">风华农资超市</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<shiro:hasRole name="admin">
			<li><a href="/sale/list">销售列表</a></li>
			</shiro:hasRole>
			<shiro:hasRole name="normal">
			<li><a href="/sale/chart/customer">销售列表</a></li>
			</shiro:hasRole>
			<li><a href="/customer/list">客户管理</a></li>
			<li><a href="/product/list">产品管理</a></li>
		</ul>
	</div>
	<div>
		<ul class="nav navbar-nav navbar-right" style="margin-right: 10px">
			<li>
				<div class="dropdown">
					<button type="button" class="btn dropdown-toggle" id="dropdownmenu"
						data-toggle="dropdown">
						<span class="glyphicon glyphicon-user btn-lg"></span> <shiro:principal property="username"/>
						<span class="caret"></span> 
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownmenu">
						<shiro:hasRole name="normal">
							<li role="presentation">
								<a role="menuitem" tabindex="1" href="/customer/edit?customerId=<shiro:principal property="userId"/> ">个人信息管理</a>
							</li>
						</shiro:hasRole>
						<li role="presentation"><a role="menuitem" tabindex="1"
							href="#">修改密码</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="1"
							href="/logout">退出</a></li>
					</ul>
				</div>
			</li>
		</ul>
	</div>
</nav>