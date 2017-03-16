/**
 * Created by 01182799 on 2017/2/24.
 */
var app = angular.module('myApp', ['ngRoute','ui.bootstrap']);

app.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when('/',{
            templateUrl:"/pages/welcome.html",
        })
        .when('/sf',{
            templateUrl: "/pages/tables.html",
            controller:'tables'
            })
        .when('/metrics',{
            templateUrl: "/pages/metrics.html",
            controller:'MetricsController',
            controllerAs: 'vm'
        })

        .otherwise({redirectTo: '/'});


    }]);
app.run(['$rootScope', '$location', function($rootScope, $location) {

    $rootScope.$on('$routeChangeSuccess', function() {
        $rootScope.path = $location.path();
      //  console.log($location.path());
    });

}]);
