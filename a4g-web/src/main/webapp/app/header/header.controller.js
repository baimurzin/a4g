/**
 * Created by vlad on 18.10.15.
 */
angular
    .module('a4g')
    .controller('HeaderController', HeaderController);

HeaderController.$inject = ['$http', '$scope', 'AuthInfo'];

function HeaderController($http, $scope, AuthInfo) {
    var vm = this;
    vm.authState = false;

    $scope.$on('authStateChanged', function (e, value) {
        vm.authState = value;
    })

    vm.logout = function () {
        AuthInfo.logout()
        console.log(1);
    }

}