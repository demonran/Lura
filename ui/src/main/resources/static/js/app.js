/**
 * Created by 01182799 on 2017/2/24.
 */
var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider',function($routeProvider) {
    $routeProvider
        .when('/',{
            templateUrl: "/pages/tables.html",
            controller:'tables'
            })
        .otherwise({redirectTo: '/'});


    }]);

