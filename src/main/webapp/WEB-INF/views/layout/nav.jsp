<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<div class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
			</a>
			<a class="brand" href="#"><span>风华农资超市</span></a>
			<div class="nav-no-collapse header-nav">
				<ul class="nav pull-right">
					<li class="dropdown">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="halflings-icon white user"></i>
							<shiro:principal property="username"/>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li class="dropdown-menu-title">
								<span>账户设置</span>
							</li>
							<shiro:hasRole name="normal">
								<li >
									<a href="/customer/edit?customerId=<shiro:principal property="userId" />" >
										<i class="halflings-icon user"></i>
										个人信息管理
									</a>
								</li>
							</shiro:hasRole>
							<li>
								<a href="/account/changePassword">
									<i class="halflings-icon lock"></i>
									修改密码
								</a>
							</li>
							<li>
								<a href="/logout">
									<i class="halflings-icon remove-sign"></i>
									退出
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
