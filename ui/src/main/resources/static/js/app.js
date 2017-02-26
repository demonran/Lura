/**
 * Created by 01182799 on 2017/2/24.
 */
var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when('/',{
            templateUrl:"/pages/welcome.html",
        })
        .when('/sf',{
            templateUrl: "/pages/tables.html",
            controller:'tables'
            })
        .when('/wx',{
            //templateUrl: "/pages/tables.html",
            //controller:'tables'
        })

        .otherwise({redirectTo: '/'});


    }]);
app.run(['$rootScope', '$location', function($rootScope, $location) {

    $rootScope.$on('$routeChangeSuccess', function() {
        $rootScope.path = $location.path();
      //  console.log($location.path());
    });

}]);
