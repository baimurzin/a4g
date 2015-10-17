/**
 * Created by vlad on 17.10.15.
 */
angular
    .module('auth')
    .service('AuthInfo', AuthInfo);

AuthInfo.$inject = ['$location', 'AuthApiService', '$q', '$rootScope'];
function AuthInfo($location, AuthApiService, $q, $rootScope) {
    var user = null;
    var checked = false;

    function setUser(User) {
        user = User;
    }

    function clearUser() {
        user = null;
    }

    return {
        login: function (form) {
            var self = this;
            return AuthApiService.login(form).then(function (data) {
                self.checkUser();
            });
        },
        logout: function () {
            AuthApiService.logout().then(function (e) {
                clearUser();
            })
        },
        isLogin: function () {
            this.checkUser();
            return !(user == null);
        },
        getUser: function () {

        },
        checkUser: function () {
            if (checked == false) return;
            checked = true;
            AuthApiService.requestSession().then(function (user) {
                setUser(user);
                $rootScope.$broadcast('authStateChanged', true);
            }, function (error) {

            })
        }
    }
}