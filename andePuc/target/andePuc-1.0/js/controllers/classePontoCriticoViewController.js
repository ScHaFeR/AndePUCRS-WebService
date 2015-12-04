    var classePontoCriticoViewCtrl = angular.module('classePontoCriticoViewCtrl', ['ngResource']);
    
    classePontoCriticoViewCtrl.controller('classePontoCriticoViewCtrl', ['$scope', '$http', function ($scope, $http) {
            $scope.classes = {};
            
            $scope.carregarClassesPontosCriticos = function(){
                $http.get("../webresources/com.andepuc.preferencias").success(function (data, status){
                    $scope.classes = data;
                });
            };
            
            
    }]);