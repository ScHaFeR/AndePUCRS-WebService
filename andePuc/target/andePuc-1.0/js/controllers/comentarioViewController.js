var comentarioViewCtrl = angular.module('comentarioViewCtrl', ['ngResource']);

comentarioViewCtrl.controller('comentarioViewCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.comentarios = [];

    $scope.carregarComentario = function(){
        $http.get("../webresources/com.andepuc.comentario").success(function (data, status){
            $scope.comentarios = data;
        });
    };
}]);