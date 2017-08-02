'use strict';
 
angular.module('myApp').controller('VideoController', ['$scope', 'VideoService', function($scope, VideoService) {
    var self = this;
    self.videos=[];
    self.submit = submit;
    $scope.message = "asdf";
 
    fetchAllVideos();
 
    function fetchAllVideos(){
        VideoService.fetchAllVideos()
            .then(
            function(d) {
                self.videos = d;
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

    function deleteVideo(id){
    	VideoService.deleteVideo(id)
            .then(
            fetchAllVideos,
            function(errResponse){
                console.error('Error while deleting Video');
            }
        );
    }
 
    function submit() {
//        if(self.user.id===null){
//            console.log('Saving New Video', self.video);
//            createUser(self.user);
//        }else{
//            updateUser(self.user, self.user.id);
//            console.log('User updated with id ', self.user.id);
//        }
//        reset();
    }

}]);