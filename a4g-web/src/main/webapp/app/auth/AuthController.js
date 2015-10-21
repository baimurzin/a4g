/**
 * Created by vlad on 20.10.15.
 */
angular
    .module('auth')
    .controller('AuthController', AuthController);
AuthController.$inject = ['$scope', '$http', '$location', '$timeout', 'AuthApiService', 'AuthInfo', '$rootScope'];
function AuthController($scope, $http, $location, $timeout, AuthApiService, AuthInfo, $rootScope) {
    AuthInfo.checkAuthUser().then(function () {
        $location.path('/profile');
    }, function () {
        $location.path('/');
    })
}