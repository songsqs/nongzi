<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="${ctx}/resource/js/myScript.js" type="text/javascript"></script>

<title>用户登录</title>

<body>
	 <div class="section" style="padding-top:100px">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" action="/login" method="post">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="userNameId" class="control-label">用户名:</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="userNameId" name="username" placeholder="用户名">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">密码:</label>
                </div>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox" id="rememberMeId" name="rememberMe">记住我</label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">登录</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

</body>
</html>