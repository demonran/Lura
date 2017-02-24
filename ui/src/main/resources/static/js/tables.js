/**
 * Created by 01182799 on 2017/2/24.
 */

app.controller('tables',function ($scope,$http) {
    $scope.a= 1;
    $http.get("/requirements")
        .success(function (response) {
            $scope.requirements = response.requirements;
        });

})