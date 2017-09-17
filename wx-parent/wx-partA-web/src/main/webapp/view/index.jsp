<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="<%=path%>/asset/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/asset/css/app.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="home-template">
	<header class="main-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<a href="<%=path%>/index" class="branding" title="陈武雄开源博客">
						<img alt="" src="http://static.ghostchina.com/image/b/46/4f5566c1f7bc28b3f7ac1fada8abe.png">
						<h2 class="text-hide">陈武雄隐藏在此</h2>
					</a>
				</div>
			</div>
		</div>
	</header>
	<nav class="main-navigation">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="navbar-header">
						<div class="nav-toggle-button college" data-target="#main-menu">
							<span class="sr-only">chen</span>
							<i class="fa fa-bars"></i>
						</div>
					</div>
					<div class="collapse navbar-collapse" id="main-menu">
							<ul class="menu">
								<li class="nav-current"  role="presentation">
									<a href="#" >首页</a>
								</li>
								<li  role="presentation">
									<a href="#" >论坛</a>
								</li>
								<li  role="presentation">
									<a href="#" >快捷手册</a>
								</li>
								<li  role="presentation">
									<a href="#" >中文文档</a>
								</li>
								<li  role="presentation">
									<a href="#" >下载</a>
								</li>
								<li  role="presentation">
									<a href="#" >关于</a>
								</li>
							</ul>
						</div>
				</div>
			</div>
		</div>
	</nav>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=path%>/asset/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>