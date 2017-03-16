/**
 * Created by 01182799 on 2017/3/16.
 */

app.controller('MetricsController' , function(MetricsService,$uibModal){

    var vm = this;
    vm.refresh = refresh;
    vm.refreshThreadDumpData = refreshThreadDumpData;
    vm.updatingMetrics = true;

    vm.refresh();


    function refresh() {
        vm.updatingMetrics = true;
        MetricsService.getMetrics().then(function (promise) {
            vm.metrics = promise;
            vm.updatingMetrics = false;
        }, function (promise) {
            vm.metrics = promise.data;
            vm.updatingMetrics = false;
        });
    }
    
    function refreshThreadDumpData() {
        MetricsService.threadDump().then(function (data) {
            $uibModal.open({
                templateUrl: '/pages/metrics.modal.html',
                controller: 'MetricsModalController',
                controllerAs: 'vm',
                size: 'lg',
                resolve: {
                    threadDump: function() {
                        return data;
                    }

                }
            });
        });
    }
})