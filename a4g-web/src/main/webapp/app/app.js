/**
 * Created by vlad on 16.10.15.
 */
angular
    .module('a4g', [
        'ngRoute',
        'auth'
    ]);

angular.module('a4g').run(AppRun);

AppRun.$inject = ['$http', 'AuthInfo', '$rootScope', '$location', '$timeout'];

function AppRun($http, AuthInfo, $rootScope, $location, $timeout) {
    AuthInfo.checkAuthUser();
    //$rootScope.$on('$routeChangeStart', function (e, next) {
    //    if (!AuthInfo.isCheckedUser()) {
    //        $location.path('/auth');
    //    }
    //    if (next.auth != undefined && next.auth && !AuthInfo.isLogin()) {
    //        $location.path('/');
    //    } else if (next.auth !== undefined && !next.auth && AuthInfo.isLogin()) {
    //        $location.path('/profile');
    //    }
    //})
}

