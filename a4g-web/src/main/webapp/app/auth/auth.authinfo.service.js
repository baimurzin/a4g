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
        getUser: function () {
            return user;
        },
        login: function (form) {
            var self = this;
            var data = {j_username: form.username, j_password:form.password};
            return AuthApiService.login(data).then(function (response) {
                $rootScope.$broadcast('authStateChanged', true);
                setUser(response.data.response);
            }, function (error) {
                return $q.reject(error);
            });
        },
        logout: function () {
            AuthApiService.logout().then(function (e) {
                clearUser();
                $rootScope.$broadcast('authStateChanged', false);
                $location.path('/');
            })
        },
        isLogin: function () {
            this.checkUser();
            return !(user == null);
        },
        checkUser: function () {
            if (checked == false) return;
            checked = true;
            AuthApiService.requestSession().then(function (user) {
                setUser(user.data.response);
                $rootScope.$broadcast('authStateChanged', true);
            }, function (error) {

            })
        },
        checkAuthUser: function () {
            var defer = $q.defer();
            AuthApiService.requestSession().then(function (user) {
                setUser(user.data.response);
                $rootScope.$broadcast('authStateChanged', true);defer.resolve();
                checked = true;
            }, function (err) {
                defer.reject(err);
                checked = true;
            })
            return defer.promise;
        },
        isCheckedUser: function () {
            return checked;
        }
    }
}