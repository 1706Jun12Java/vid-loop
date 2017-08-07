angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){
	var REST_SERVICE_URI = 'http://ec2-54-210-86-227.compute-1.amazonaws.com:8080/vid-loop/user/';
	
	var factory = {
			loginUser: loginUser
	}
	
	return factory;
	
	function loginUser(username, password){
		var user = {'username':username, 'password':password};
		var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+"get", user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while login');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	
	
}]);
