/**
 * Created by vlad on 21.10.15.
 */
angular
    .module('a4g')
    .controller('AppController', AppController);

AppController.$inject = ['$scope', 'AuthInfo'];

function AppController($scope, AuthInfo) {
    AuthInfo.checkAuthUser().then(function () {
        $scope.currentUser = AuthInfo.getUser();
    })
}