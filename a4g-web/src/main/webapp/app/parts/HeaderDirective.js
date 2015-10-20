/**
 * Created by vlad on 18.10.15.
 */

angular
    .module('a4g')
    .directive('appHeader', HeaderDirective);

function HeaderDirective() {
    return {
        templateUrl: '/app/parts/t/header.html',
        controller: 'HeaderController as header'
    }
}