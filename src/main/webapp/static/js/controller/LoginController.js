'use strict';
angular.module('myApp').controller('LoginController', ['$scope', 'UserService', function($scope, UserService) {
	
	$scope.loggedIn = document.cookie;
	
	console.log(document.cookie);
	
	$scope.login = login;
	
	
	function login(){
		UserService.loginUser($scope.username,$scope.password)
		.then(function(d){
			console.log(d);
			$scope.loggedIn = true;
			document.cookie=d;
		}, 
		function(errResponse){console.log(errResponse)}
		);
	}

}]);
