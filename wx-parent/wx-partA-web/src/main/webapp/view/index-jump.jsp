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

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Email">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Password">
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
			</form>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="jumbotron">
		<div class="container">
			<h1>Hello, world!</h1>
			<p>This is a template for a simple marketing or informational
				website. It includes a large callout called a jumbotron and three
				supporting pieces of content. Use it as a starting point to create
				something more unique.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more &raquo;</a>
			</p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2>Heading </h2>
				<p>Donec id elit non mi porta
				gravida at eget metus. Fusce dapibus, tellus ac cursus commodo,
				tortor mauris condimentum nibh, ut fermentum massa justo sit amet
				risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
				odio dui.</p>
				<a class="btn btn-default btn-lg" href="#" role="button">View details &raquo;</a>
			</div>
			<div class="col-md-4">
				<h2>Heading </h2>
				<p>Donec id elit non mi porta
				gravida at eget metus. Fusce dapibus, tellus ac cursus commodo,
				tortor mauris condimentum nibh, ut fermentum massa justo sit amet
				risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
				odio dui.</p>
				<a class="btn btn-default btn-lg" href="#" role="button">View details &raquo;</a>
			</div>
			<div class="col-md-4">
				<h2>Heading </h2>
				<p>Donec id elit non mi porta
				gravida at eget metus. Fusce dapibus, tellus ac cursus commodo,
				tortor mauris condimentum nibh, ut fermentum massa justo sit amet
				risus. Etiam porta sem malesuada magna mollis euismod. Donec sed
				odio dui.</p>
				<a class="btn btn-default btn-lg" href="#" role="button">View details &raquo;</a>
			</div>
		</div>
		
			<hr/>
	
		<footer>
			<p>© 2016 Company, Inc.</p>
		</footer>
	</div>
	

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<%=path%>/asset/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>