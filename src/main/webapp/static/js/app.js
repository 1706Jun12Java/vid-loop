var app = angular.module('myApp',['ngRoute']);


app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "static/views/videos.html",
        controller: "VideoController"
    })
    .when("/upload", {
        templateUrl : "static/views/uploadpage.html",
        controller: "UploadController"
    })
    .when("/profile", {
        templateUrl : "static/views/profile.html" ,
        controller: "ProfileController"
     })
     .otherwise({redirectTo: '/'});
});

