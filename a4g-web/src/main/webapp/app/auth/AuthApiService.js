/**
 * Created by vlad on 17.10.15.
 */

angular
    .module('auth')
    .service('AuthApiService', AuthApiService);

AuthApiService.$inject = ['$http'];
function AuthApiService($http) {
    return {
        login:login
    }

    function login(form) {
        return $http.post('')
    }
}