'use strict';
 
angular.module('myApp').controller('VideoController', ['$scope', 'VideoService', function($scope, VideoService) {
    var self = this;
    self.videos=[];
    $scope.message = "Greetings from VidLoop";
 
    fetchAllVideos();
 
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