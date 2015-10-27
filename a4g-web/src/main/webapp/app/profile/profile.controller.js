/**
 * Created by vlad on 21.10.15.
 */
angular
    .module('profile')
    .controller('ProfileController', ProfileController);

ProfileController.$inject = ['$scope', 'ProfileApi', 'currentUser'];
function ProfileController($scope, ProfileApi, currentUser) {
    var vm = this;
    $scope.user = currentUser;

}