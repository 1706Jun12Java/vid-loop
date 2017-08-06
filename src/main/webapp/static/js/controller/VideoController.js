'use strict';
 
angular.module('myApp').controller('VideoController', ['$scope', 'VideoService', function($scope, VideoService) {
    $scope.message = "Greetings from VidLoop";
    $scope.name = "hi";
	$scope.videosLeft=[];
	$scope.videosRight=[];
	
 
//    fetchAllVideos();
 
    function fetchAllVideos(){
        VideoService.fetchAllVideos()
            .then(
            function(d) {
                $scope.videosLeft = d.slice(0,d.length/2);
                $scope.videosRight = d.slice(d.length/2,d.length);
                console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching Videos');
            }
        );
    }
 
    function saveUser(user){
    	VideoService.saveUser(user)
            .then(
            fetchAllVideos,
            function(errResponse){
                console.error('Error while saving Video');
            }
        );
    }

  

}]);