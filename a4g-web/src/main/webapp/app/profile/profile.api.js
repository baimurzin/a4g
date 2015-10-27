/**
 * Created by vlad on 21.10.15.
 */

angular
    .module('profile')
    .service('ProfileApi', ProfileApi);

ProfileApi.$inject = ['$http', '$q'];

function ProfileApi($http, $q) {
    return {
        getCurrentUser: getCurrentUser,
        updateProfile: updateProfile
    };

    function updateProfile() {

    }

    function getCurrentUser() {
        var dfd = $q.defer();
        $http.get('/api/session/').success(function (u) {
            dfd.resolve(u.response);
        }).error(function (err) {
            dfd.reject(err);
        })
        return dfd.promise;
    }
}