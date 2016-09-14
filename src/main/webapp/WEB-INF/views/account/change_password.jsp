<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ctx}/resource/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="${ctx}/resource/js/myScript.js" type="text/javascript"></script>
<script src="${ctx}/resource/js/bootstrap-datetimepicker.min.js"
	type="text/javascript" charset="UTF-8"></script>
<script
	src="${ctx}/resource/js/locales/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="UTF-8"></script>

<title>客户管理</title>

<body>
	<%@ include file="../layout/nav.jsp"%>

	<div class="section">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="../layout/sidebar.jsp"%>
			</div>
			<div class="col-md-9">
				<form class="form-horizontal" role="form" >
					<div class="form-group">
						<div class="col-sm-2">
							<label for="originPasswordId" class="control-label">原密码:</label>
						</div>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="originPasswordId"
								placeholder="请输入原始密码" name="originPassword">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="newPasswordId" class="control-label">新密码:</label>
						</div>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="newPasswordId"
								placeholder="请输入新密码" name="newPassword">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="confirmPasswordId" class="control-label">确认:</label>
						</div>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="confirmPasswordId"
								placeholder="确认新密码" name="confirmPassword">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-default"
								onclick="onSubmit();">确定</button>
							<a href="/customer/list">
								<button type="button" class="btn btn-default">取消</button>
							</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		
		function onSubmit() {
			if (!checkAndGetSelectValue("originPasswordId", "原始密码不能为空", "0")) {
				return false;
			}

			if (!checkAndGetSelectValue("newPasswordId", "新密码不能为空", "0")) {
				return false;
			}

			if (!checkAndGetSelectValue("confirmPasswordId", "两次输入密码不一致", "0")) {
				return false;
			}

			var originPasswordParam = $("#originPasswordId").val();
			var newPasswordParam = $("#newPasswordId").val();
			var confirmPasswordParam = $("#confirmPasswordId").val();
			
			if(newPasswordParam != confirmPasswordParam){
				alert("两次输入的密码不一致！");
				return false;
			}
			
			$.ajax({
				type:"post",
				url:"/account/changePassword.do",
				data:{
					originPassword:originPasswordParam,
					newPassword:newPasswordParam
				},
				success:function(msg){
					console.log(msg);
					
					if ("true" == msg) {
						alert("密码更改成功");
						//更改成功后跳转
						window.location.href = "/logout";
					}else{
						alert("密码修改失败,请确定原始密码填写正确!");
						return false;
					}
				},
				error : function(msg) {
					alert("更改密码失败,如果多次失败,请与管理员联系");
					return false;
				}
			});
		}
	</script>
</body>
</html>