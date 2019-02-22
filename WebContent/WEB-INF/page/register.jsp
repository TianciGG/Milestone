<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="base.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人生里程碑管理系统 注册</title>
<%@include file="registerHeader.jsp"%>
</head>
<body class="style-2">

	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<ul class="menu">
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">

				<!-- Start Sign In Form -->
				<form action="#" class="fh5co-form animate-box"
					data-animate-effect="fadeInLeft">
					<h2>注册</h2>
					<div class="form-group">
						<div class="alert alert-success" role="alert">请填写您的个人信息</div>
					</div>
					<div class="form-group">
						<label for="name" class="sr-only">Name</label> <input type="text"
							class="form-control" id="name" placeholder="用户名"
							autocomplete="off">
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">Email</label> <input
							type="email" class="form-control" id="email" placeholder="邮箱"
							autocomplete="off">
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">Password</label> <input
							type="password" class="form-control" id="password1"
							placeholder="密码" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="re-password" class="sr-only">Re-type Password</label>
						<input type="password" class="form-control" id="password2"
							placeholder="重复密码" autocomplete="off">
					</div>
					<!-- <div class="form-group">
						<label for="remember"><input type="checkbox" id="remember">
							记住我</label>
					</div> -->
					<div class="form-group">
						<p>
							已有账号? <a href="index.jsp"> 登录</a>
						</p>
					</div>
					<div class="form-group">
						<input type="button" value="注册" class="btn btn-primary" onclick="register()">
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
			<div class="col-md-6" style="float: right; padding: 50px 150px;">
				<img src="images/icons8-记分牌-128.png">
			</div>
			<div class="col-md-6">
				<img src="images/里程碑字体22.png" />
			</div>
		</div>
		<div class="row" style="padding-top: 60px; clear: both;">
			<div class="col-md-12 text-center">
				<p>
					<small>&copy; All Rights Reserved.<a
						href="goToRegisterPage.do">恒诚科技</a> - System is
						<a href="goToRegisterPage.do">人生里程碑管理系统</a></small>
				</p>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
	<script src="js/logic/register.js"></script>
</body>
</html>