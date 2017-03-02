/**
 * Created by 01182799 on 2017/2/28.
 */
app.controller('RequirementDialogController',function ($scope,$uibModalInstance,entity) {
    $scope.requirement = entity;

    $scope.clear = clear;

    function clear () {
        $uibModalInstance.dismiss('cancel');
    }


});


