/**
 * Created by vlad on 17.10.15.
 */

angular
    .module('auth')
    .config(AuthRoutes);

AuthRoutes.$inject = ['$routeProvider'];
function AuthRoutes($routeProvider) {
    $routeProvider
        .when('/registration', {
            templateUrl: '/app/auth/partials/auth.registration.template.html',
            controller: 'RegistrationController as ctrl'
        }).when('/login', {
            templateUrl: '/app/auth/partials/auth.login.template.html',
            controller: 'LoginController as ctrl'
        }).when('/auth', {
            controller: 'AuthController',
            template: ''
        })
}