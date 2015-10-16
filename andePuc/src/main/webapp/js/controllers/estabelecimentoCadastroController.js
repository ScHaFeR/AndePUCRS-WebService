    var estabelecimentoCadastroCtrl = angular.module('estabelecimentoCadastroCtrl', ['ngResource']);

    estabelecimentoCadastroCtrl.controller('estabelecimentoCadastroCtrl', ['$scope', '$http', function ($scope, $http) {
            $scope.Estabelecimento = {};
            
            $scope.confSenha;
            
            $scope.salvar = function(){
                
                if($scope.Estabelecimento.nome == null || $scope.Estabelecimento.descricao == null || $scope.Estabelecimento.latitude == null
                       || $scope.Estabelecimento.longitude == null || $scope.Estabelecimento.idTpEstabelecimento == null){
                    alert('Preencha todos os campos!');
                    return;
                }
               
                $scope.Estabelecimento.nroIntEstabelecimento = "";
                $http.post("../webresources/com.andepuc.estabelecimentos", $scope.Estabelecimento).success(function (data){
                        alert('Cadastrado com sucesso');
                        window.location.href="../";
                }).error(function(data, status){
                    $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
                    alert($scope.messageDeErro);
                });
            };
    }]);