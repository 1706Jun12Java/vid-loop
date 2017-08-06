'use strict';
 
angular.module('myApp').controller('VideoController', ['$scope', 'VideoService', function($scope, VideoService) {
    var self = this;
    self.videos=[];
    $scope.message = "Greetings from VidLoop";
    $scope.name = "hi";
	$scope.videos = [{
		name : "Bunny video",
		info : "This video is about a bunny coming out",
		likes : 5,
		loops : 1
		},
		{
		name : "Riding my bike",
		info : "Filming while riding",
		likes : 2,
		loops : 5
		},
		{
		name : "Same bunny video",
		info : "Decided to upload this video again",
		likes : 10,
		loops :10
		}
	];
	
 
//    fetchAllVideos();
 
    function fetchAllVideos(){
        VideoService.fetchAllVideos()
            .then(
            function(d) {
                self.videos = d;
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