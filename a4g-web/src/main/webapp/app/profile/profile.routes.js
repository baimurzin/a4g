/**
 * Created by vlad on 21.10.15.
 */


angular
    .module('profile')
    .config(ProfileRoutes);

ProfileRoutes.$inject = ['$routeProvider'];
function ProfileRoutes($routeProvider) {
    $routeProvider.when('/profile', {
        controller: 'ProfileController as ctrl',
        templateUrl: '/app/profile/partials/profile.html',
        resolve: {
            currentUser: loadProfile
        }
    })
}

loadProfile.$inject = ['ProfileApi'];
function loadProfile(ProfileApi) {
    return ProfileApi.getCurrentUser();
}