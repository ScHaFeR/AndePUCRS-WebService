    var classePontoCriticoCadastroCtrl = angular.module('classePontoCriticoCadastroCtrl', ['ngResource']);

    classePontoCriticoCadastroCtrl.controller('classePontoCriticoCadastroCtrl', ['$scope', '$http', function ($scope, $http) {
            $scope.classePontoCritico = {};
           
            $scope.salvar = function(){
                if($scope.classePontoCritico.nome == null || $scope.classePontoCritico.status == null || $scope.classePontoCritico.valor == null){
                    alert('Preencha todos os campos!');
                    return;
                }

                $http.post("../webresources/com.andepuc.preferencias", $scope.classePontoCritico).success(function (data){
                        alert('Cadastrado com sucesso');
                        window.location.href="../";
                }).error(function(data, status){
                    $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
                    alert($scope.messageDeErro);
                });
            };
    }]);