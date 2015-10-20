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
            var data = {j_username: form.username, j_password:form.password};
            return AuthApiService.login(data).then(function (response) {
                $rootScope.$broadcast('authStateChanged', true);
                setUser(response);
            }, function (error) {
                return $q.reject(error);
            });
        },
        logout: function () {
            AuthApiService.logout().then(function (e) {
                clearUser();
                $rootScope.$broadcast('authStateChanged', false);
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