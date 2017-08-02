'use strict';
 
angular.module('myApp').controller('VideoController', ['$scope', 'VideoService', function($scope, VideoService) {
    var self = this;
    self.video={id:null,username:'',address:'',email:''};
    self.videos=[];
 
    self.submit = submit;
//    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
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

 
    function remove(id){
//        console.log('id to be deleted', id);
//        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
//            reset();
//        }
//        deleteUser(id);
    }
 
 
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);