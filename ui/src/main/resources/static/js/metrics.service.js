/**
 * Created by 01182799 on 2017/3/16.
 */

app.factory('MetricsService' , function ($http) {
    var service = {
        getMetrics: getMetrics,
        threadDump: threadDump
    };

    return service;
    
    function getMetrics() {
        return $http.get('/management/metrics').then(function (response) {
            return response.data;
        });
    }
    
    function threadDump() {
        return $http.get('management/dump').then(function (response) {
            return response.data;
        });
    }
})
