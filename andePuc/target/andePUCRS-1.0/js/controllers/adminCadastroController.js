    var adminCadastroCtrl = angular.module('adminCadastroCtrl', ['ngResource']);

    adminCadastroCtrl.controller('adminCadastroCtrl', ['$scope', '$http', function ($scope, $http) {
            $scope.Admin = {};
            
            $scope.confSenha;
            
            $scope.salvar = function(){
                
                if($scope.Admin.nome == null || $scope.Admin.email == null || $scope.Admin.hashSenha == null){
                    alert('Preencha todos os campos!');
                    return;
                }
                
                if($scope.confSenha !=  $scope.Admin.hashSenha){
                    alert('As senhas divergem!');
                    return;
                }
               
                $scope.Admin.nroIntUsario = "";
                $http.post("../webresources/com.andepuc.admin", $scope.Admin).success(function (data){
                        alert('Cadastrado com sucesso');
                        window.location.href="../";
                }).error(function(data, status){
                    $scope.messageDeErro = "Aconteceu um problema ao cadastrar o admin : "+data; 
                    alert($scope.messageDeErro);
                });
            };
    }]);