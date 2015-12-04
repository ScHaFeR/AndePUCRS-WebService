    var recSenhaCtrl = angular.module('recSenhaCtrl', ['ngResource']);

    recSenhaCtrl.controller('recSenhaCtrl', ['$scope', '$http', function ($scope, $http) {
            $scope.Usuario;
            $scope.novaSenha = [];
            
            $scope.recuperar = function(){
                $http.get("../webresources/com.andepuc.usuario").success(function (data, status){
                    var achou = false;
                    if(data != null && $scope.Usuario != null){
                        for(var i = 0; i < data.length; i++){
                            if(data[i].email == $scope.Usuario.email){
                               achou = true;
                               alert("Sua senha: "+data[i].hashSenha);
                               break;
                            }
                        }
                        if(!achou)
                            alert("Usuario nao cadastrado");
                    }
                });
            };
    }]);