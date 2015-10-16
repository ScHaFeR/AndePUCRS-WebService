    var usuarioCadastroCtrl = angular.module('usuarioCadastroCtrl', ['ngResource']);

    usuarioCadastroCtrl.controller('usuarioCadastroCtrl', ['$scope', '$http', function ($scope, $http) {
            $scope.Usuario = {};
            
            $scope.confSenha;
            
            $scope.salvar = function(){
                
                if($scope.Usuario.nome == null || $scope.Usuario.email == null || $scope.Usuario.hashSenha == null){
                    alert('Preencha todos os campos!');
                    return;
                }
                
                if($scope.confSenha !=  $scope.Usuario.hashSenha){
                    alert('As senhas divergem!');
                    return;
                }
               
                $scope.Usuario.nroIntUsuario = "";
                $http.post("webresources/com.andepuc.usuario", $scope.Usuario).success(function (data){
                        alert('Cadastrado com sucesso');
                        window.location.href="../";
                }).error(function(data, status){
                    $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
                    alert($scope.messageDeErro);
                });
            };
    }]);