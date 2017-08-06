'use strict';
angular.module('myApp').factory('VideoService', ['$http', '$q', function($http, $q){
	 
    var REST_SERVICE_URI = 'http://ec2-54-210-86-227.compute-1.amazonaws.com:8080/vid-loop/video/all';
 
    var factory = {
        fetchAllVideos: fetchAllVideos,
        saveVideo: saveVideo
    };
 
    return factory;
 
    function fetchAllVideos() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
            	deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Videos');
                console.error(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function saveVideo(Video, id) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+id, Video)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Video');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
 
}]);