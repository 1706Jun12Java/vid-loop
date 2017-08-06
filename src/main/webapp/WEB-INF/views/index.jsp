<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular-route.js"
	type="text/javascript"></script>
<link href="css/main.css" rel="stylesheet" />

<title>VidLoop</title>
</head>
<body>

<!-- side nav bar -->
<div class="w3-sidebar w3-bar-block w3-card-2 w3-animate-left" style="display:none" id="mySidebar">
  <h3 class="sideTitles w3-bar-item w3-border-bottom" >Categories</h3>
  <a href="#" class="w3-bar-item w3-button">Funny</a>
  <a href="#" class="w3-bar-item w3-button">Animals</a>
  <a href="#" class="w3-bar-item w3-button">Music</a>
  <h3 class="sideTitles w3-bar-item w3-border-bottom" >Search</h3>
  <form>
  <input type="search" id="search" placeholder="Search for Video" style="margin-left: 5px;" ><br>
  <input type="submit" value="submit" style="margin-left: 5px;" >
  </form>
</div>

<!-- top nav bar -->
<div zclass="w3-main" id="main">
<div class="w3-top">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button class="w3-button w3-xlarge" onclick="decideNav()"  id="button1" ><span class="glyphicon glyphicon-search"></span></button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="frontdesign.html">Home</a></li>
		<li><a href="#">Upload</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <div class="btn-ground text-center">
                    <button type="button" class="btn btn-primary w3-hover-black" data-toggle="modal" data-target="#login-modal"><i class="fa fa-search"></i><span class="glyphicon glyphicon-log-in"></span> Login</button>
                </div>
      </ul>
    </div>
  </div>
</nav>
</div>

<!-- Login	-->
<div class="modal fade" id="login-modal" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h1>Login to Your Account</h1><br>
				  <form>
					<p>Username:</p>
					<input type="text" name="username" placeholder="Username" required>
					<p>Password</p>
					<input type="password" name="pass" placeholder="Password" required>
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
					
				  <div class="login-help">
					<a href="#register-modal" data-toggle="modal" data-dismiss="modal">Register</a>
				  </div>
				</div>
			</div>
		  </div>

<!-- Register -->		  
<div class="modal fade" id="register-modal" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h1>Registration Form</h1><br>
				  <form>
					<p>Enter your first name:</p>
					<input type="text" name="firstName	" placeholder="First Name" required>
					<p>Enter your last name:</p>
					<input type="text" name="lastName" placeholder="Last Name" required>
					<p>Enter a username:</p>
					<input type="text" name="user" placeholder="Username" required>
					<p>Enter a password:</p>
					<input type="password" name="pass" placeholder="Password" required>
					<p>Enter your email:</p>
					<input type="text" name="email" placeholder="Email" required>
					<br><br>
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
				</div>
			</div>
		  </div>

		  
<!-- Header Text -->		  
<div class="w3-container" id="topword">
<div class="col-12 text-center"> 
  <h1>Welcome to VidLoop</h1>
  <p style="color: #472303">Feel free to browse through our collection of videos</p>
</div>
</div>
<br><br>

<div class="w3-container" id="bgg">
  <img src="https://cdn.pbrd.co/images/GEiiMUV.png" width="100%" >

</div>

    
</header>

<!-- videos -->

<div id="move">
<div class="w3-container" id="topsections">
<div class="middlerow col-sm-2 text-center w3-round"" > 
<h3>Popular Videos</h3>
</div>
<div class="middlerow col-sm-8 text-center" > 
<h2>Top Video of The Day</h2>
</div>
<div class="middlerow col-sm-2 text-center" > 
<h3>Recent Videos</h3>
</div>
</div>

<!-- First row -->
<div class="w3-container" ng-controller="VideoController">
<div class="col-sm-2 text-left" id="leftrow"> 


<div class="vid" ng-repeat="video in videos">
  <video  width=100% id="vid1" ng-src= " {{ video.link }} " type="video/mp4" onmouseover="play()" onmouseleave="pause()" >
    Your browser does not support HTML5 video.
  </video>
  <div class="title">
  <h4>{{ video.vidName }} </h4>
  </div>
  <div class="info">
  <h5>Posted by: {{ video.v_userId.username }}</h5>
  <br>
  <h6> Likes: {{ video.likes }}  Loops: {{ video.loopCount }} </h6>
  </div>

  
  </div>
</div>
	  
	  
<!-- Second row-->

<div class="middlerow col-sm-8 text-left" >
<div class="w3-white" >
<div class="vidm" >
  <video  width=100% class="vidr" >
    <source src="http://clips.vorwaerts-gmbh.de/VfE_html5.mp4" type="video/mp4" />
    Your browser does not support HTML5 video.
  </video>
  <div class="title">
  <h4>Title</h4>
  </div>
  <div class="info">
  <h5>User info or description</h5>
  </div>
  </div>
  </div>
  
  </div>

	  
	  <!-- Third row -->
<div class="col-sm-2 text-left" id="leftrow"> 


<div class="vid" ng-repeat="video in videos">
  <video  width=100% id="vid1" ng-src= " {{ video.link }} " type="video/mp4" onmouseover="play()" onmouseleave="pause()" >
    Your browser does not support HTML5 video.
  </video>
  <div class="title">
  <h4>{{ video.vidName }} </h4>
  </div>
  <div class="info">
  <h5>Posted by: {{ video.v_userId.username }}</h5>
  <br>
  <h6> Likes: {{ video.likes }}  Loops: {{ video.loopCount }} </h6>
  </div>

  
  </div>
</div>


</div>
</div>
	
	
<footer id="footer">
<h5>VidLoop inc.</h5>
</footer>
<script src="js/app.js"></script>
<script src="js/service/video_service.js"></script>
<script src="js/controller/VideoController.js"></script>
<script src="js/main.js"></script>
</body>
</html>
