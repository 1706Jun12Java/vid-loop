'use strict';
var app = angular.module('myApp',['ngRoute']);


app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "index.jsp"
    })
    .when("/upload", {
        templateUrl : "upload.jsp",
        controller: "UploadController"
    })
    .when("/profile", {
        templateUrl : "profile.jsp" ,
        controller: "ProfileController"
     })
     .otherwise({redirectTo: '/'});
});

