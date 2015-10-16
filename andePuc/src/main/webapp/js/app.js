angular.module('', ['$routeProvider', '$controllerProvider', 'service']).
// Declare app level module which depends on filters, and services
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/index', {templateUrl: 'index.html', controller: 'usuarioCadastroCtrl', resolve : usuarioCadastroCtrl})
        $routeProvider.otherwise({redirectTo: '/index'});
    }]);