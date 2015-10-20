/**
 * Created by vlad on 18.10.15.
 */
angular
    .module('a4g')
    .controller('HeaderController', HeaderController);

HeaderController.$inject = ['$http'];

function HeaderController($http) {
    var vm = this;
    vm.authState = false;



}