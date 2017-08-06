'use strict';
var App = angular.module('myApp',['ngRoute']);


app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "index.jsp"
    })
    .when("/upload", {
        templateUrl : "upload.jsp"
    })
    .when("/profile", {
        templateUrl : "profile.jsp" 
     })
});

