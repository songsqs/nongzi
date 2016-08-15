<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>添加产品</title>
<link href="${ctx}/resource/css/base.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/resource/css/haiersoft.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/resource/css/print.css" rel="stylesheet"
	type="text/css" />
<script src="${ctx}/resource/js/jquery-1.10.1.min.js"
	type="text/javascript"></script>
<script src="${ctx}/resource/js/side.js" type="text/javascript"></script>
<script src="${ctx}/resource/js/myScript.js" type="text/javascript"></script>

<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
		<![endif]-->
</head>

<body>
	<!-- 侧边栏 -->
	<div class="wrap_left" id="frmTitle" name="fmTitle">
		<!-- Logo -->
		<div id="Logo">
			<span>人单合一</span>
		</div>
		<!-- /Logo -->

		<!-- menu_list -->

		<div class="menu_list">
			<dl>
				<dt>
					<span>一级分类名称</span>
				</dt>
				<dd>
					<a href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a> <a
						href="" title="二级分类" class="active">二级分类</a> <a href=""
						title="二级分类">二级分类</a>
				</dd>

				<dt>
					<span>一级分类名称</span>
				</dt>
				<dd>
					<a href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a> <a
						href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a>
				</dd>

				<dt>
					<span>一级分类名称</span>
				</dt>
				<dd>
					<a href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a> <a
						href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a>
				</dd>

				<dt>
					<span>一级分类名称</span>
				</dt>
				<dd>
					<a href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a> <a
						href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a>
				</dd>

				<dt>
					<span>一级分类名称</span>
				</dt>
				<dd>
					<a href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a> <a
						href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a>
				</dd>

				<dt>
					<span>一级分类名称</span>
				</dt>
				<dd>
					<a href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a> <a
						href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a>
				</dd>

				<dt>
					<span>一级分类名称</span>
				</dt>
				<dd>
					<a href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a> <a
						href="" title="二级分类">二级分类</a> <a href="" title="二级分类">二级分类</a>
				</dd>
			</dl>
		</div>

		<script>
			$(function() {
				$(".menu_list dd");
				$(".menu_list dt").click(function() {
					$(this).toggleClass("open").next().slideToggle("fast");
				});
			});
		</script>
		<!-- /menu_list -->
	</div>
	<!-- 侧边栏 end-->

	<!-- picBox -->
	<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>
	<!-- /picBox -->

	<!-- wrap_right -->
	<div class="wrap_right">
		<header>
			<!-- Header -->
			<div id="Header">
				<!-- Head -->
				<div id="Head">
					<h1 title="风华农资管理系统">
						<img
							src="${ctx}/resource/images/common/page_ttl_fenghuanongzi.gif"
							width="398" height="26" alt="风华农资管理系统">
					</h1>
					<script language="javascript">
						function showmenu(id) {
							id.style.visibility = "visible";
						}
						function hidmenu() {
							UserList.style.visibility = "hidden";
						}
						document.onclick = hidmenu;
					</script>
					<div class="user">
						<a href="javascript:showmenu(UserList)">admin</a>
						<div id="UserList">
							<a href="">修改</a> <a href="">注销</a> <a href="">退出</a>
						</div>
					</div>
				</div>
				<!-- /Head -->
			</div>
			<!-- /Header -->
		</header>

		<div id="Contents">
			<div id="BtmMain">
				<span class="ttl">产品属性:</span>
				<div class="txtbox floatL mag_r20">
					<span class="sttl">产品名称:</span> <input name="" id="nameId"
						type="text" size="10" />
				</div>
				<div class="txtbox floatL mag_r20">
					<span class="sttl">制造商:</span> <input id="manufacturerId" type="text"
						size="10" />
				</div>
				<div class="txtbox floatL mag_r20">
					<span class="sttl">单价(元):</span> <input id="priceId" type="text"
						size="8" />
				</div>
				<div class="txtbox floatL mag_r20">
					<span class="sttl">最低单价(元):</span> <input id="priceLowerId" type="text"
						size="10" />
				</div>
			</div>
			<form action="add.do" method="post" >
				<!-- add.do field -->
				<input type="hidden" id="nameInForm" name="name" />
				<input type="hidden" id="manufacturerInForm" name="manufacturer" />
				<input type="hidden" id="priceInForm" name="price" />
				<input type="hidden" id="priceLowerInForm" name="priceLower" />
				<!-- add.do field end -->

				<!-- btn_box -->
				<div class="btn_box floatR mag_l20">
					<input name="" type="submit" value="确定"
						onmousemove="this.className='input_move'"
						onmouseout="this.className='input_out'"
						onclick="return onSubmit();">
				</div>

				<div class="btn_box floatR mag_l20">
					<input name="" type="button" value="重置"
						onmousemove="this.className='input_move'"
						onmouseout="this.className='input_out'">
				</div>
				<div class="btn_box floatR mag_l20">
					<input name="" type="button" value="返回首页"
						onmousemove="this.className='input_move'"
						onmouseout="this.className='input_out'">
				</div>
				<!-- /btn_box -->
			</form>
		</div>

	</div>
	<!-- wrap_right end -->

	<script type="text/javascript">
		function onSubmit(){
			if(!checkAndSetSelectInput("nameInForm","nameId","产品名称不能为空","0")){
				return false;
			}
			if(!checkAndSetSelectInput("manufacturerInForm","manufacturerId","制造商不能为空","0")){
				return false;
			}
			if(!checkAndSetSelectInput("priceInForm","priceId","单价不能为空","0") || !checkIsNaN("priceId","单价必须是数字")){
				return false;
			}
			if(!checkAndSetSelectInput("priceLowerInForm","priceLowerId","最低单价不能为空","0") || !checkIsNaN("priceLowerId","最低单价必须是数字")){
				return false;
			}
			
			
			return true;
		}
	</script>

</body>
</html>