/**
 * Created by vlad on 17.10.15.
 */

angular
    .module('auth')
    .service('AuthApiService', AuthApiService);

AuthApiService.$inject = ['$http'];
function AuthApiService($http) {
    return {
        login:login,
        session: session,
        logout: logout,
        requestSession: requestSession
    };

    function requestSession() {
        return $http.get('/api/session');
    }

    function login(form) {
        return $http.post('/j_spring_security_check', $.param(form),
            {headers: {'Content-Type': 'application/x-www-form-urlencoded'}});
    }

    function session() {
        return $http.get('/api/session');
    }

    function logout() {
        return $http.post('/logout');
    }
}