/**
 * Created by 01182799 on 2017/2/24.
 */

app.controller('tables',['$scope','$http','$uibModal',function ($scope,$http,$uibModal) {

    $http.get("/requirements")
        .success(function (response) {
            $scope.requirements = response.requirements;
        });

    $scope.delete = function (requirement) {
         $http.delete("/requirement/"+ requirement.id)
             .success(function () {
                 $scope.requirements.splice(requirement,1)
         });
    };

    $scope.edit = function (requirement) {
        $uibModal.open({
            templateUrl:'/pages/requirement-dialog.html',
            controller: 'RequirementDialogController',
            backdrop: 'static',
            resolve: {entity:angular.copy(requirement)}
        })
    }
    $scope.view = function (requirement) {
        $uibModal.open({
            templateUrl:'/pages/requirement-detail.html',
            controller: 'RequirementDetailController',
            backdrop: 'static',
            resolve: {entity:angular.copy(requirement)}
        })
    }

}])