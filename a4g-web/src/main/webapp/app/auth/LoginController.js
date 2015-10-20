/**
 * Created by vlad on 17.10.15.
 */
angular
    .module('auth')
    .controller('LoginController', LoginController);

LoginController.$inject = ['AuthInfo','AuthApiService'];
function LoginController(AuthInfo, AuthApiService) {
    var vm = this;
    vm.user = {};
    vm.login = function () {
        AuthInfo.login(vm.user).then(function (response) {
            console.log(response);
        })
    };

    vm.session = function () {
        AuthApiService.session().then(function (d) {
            console.log(d);
        }, function (e) {
            console.log(e);
        });
    }
}