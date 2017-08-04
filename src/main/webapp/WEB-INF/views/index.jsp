<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-route.js"
	type="text/javascript"></script>
<title>VidLoop</title>
</head>
<body ng-controller="VideoController">
<h1>{{message}}</h1>
<a class="btn btn-primary btn-md" href="#/">home</a>
	<a class="btn btn-primary btn-md" href="#/video">video</a>
	<a class="btn btn-primary btn-md" href="#/profile">profile</a>
<script src="js/app.js"></script>
<script src="js/service/video_service.js"></script>
<script src="js/controller/VideoController.js"></script>
</body>
</html>
