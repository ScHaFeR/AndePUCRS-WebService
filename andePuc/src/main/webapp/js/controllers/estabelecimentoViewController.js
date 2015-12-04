    var estabelecimentoViewCtrl = angular.module('estabelecimentoViewCtrl', ['ngResource']);

    estabelecimentoViewCtrl.controller('estabelecimentoViewCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.estabelecimentos = [];

        $scope.carregarPontosCriticos = function(){
            $http.get("../webresources/com.andepuc.estabelecimentos").success(function (data, status){
                $scope.estabelecimentos = data;
            });
        };
            
    }]);