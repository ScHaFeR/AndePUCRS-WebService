    var estabelecimentoCadastroCtrl = angular.module('estabelecimentoCadastroCtrl', ['ngResource']);

    estabelecimentoCadastroCtrl.controller('estabelecimentoCadastroCtrl', ['$scope', '$http', function ($scope, $http) {
            
            $scope.listaTpEst = [];
            $scope.tp = {descricao:"Tipo"};
            
            $scope.inicializaDropDown = function() {
                angular.element('#dropdownTpEst a.dropdown-button').dropdown({constrain_width: false, belowOrigin: true});
                
                $http.get("../webresources/com.andepuc.tipoestabelecimento").success(function (data, status){
                    $scope.listaTpEst = data;
                });
            }
            
            $scope.selecionaOpcao = function(tpEst){
                $scope.tp = tpEst;
                console.log($scope.tp);
            }
            
            $scope.Estabelecimento = {};
            
            $scope.confSenha;
            
            $scope.salvar = function(){
                
                if($scope.Estabelecimento.nome == null || $scope.Estabelecimento.descricao == null || $scope.Estabelecimento.latitude == null
                       || $scope.Estabelecimento.longitude == null){
                    alert('Preencha todos os campos!');
                    return;
                }
                
                if($scope.tp.nroIntTipoEstabelecimento == null){
                    alert('Selecione ao menos um tipo de estabelecimento');
                    return;
                }
                
                $scope.Estabelecimento.nroIntTipoEstabelecimento = $scope.tp;
                console.log($scope.Estabelecimento);
                $http.post("../webresources/com.andepuc.estabelecimentos", $scope.Estabelecimento).success(function (data){
                        alert('Cadastrado com sucesso');
                        window.location.href="../";
                }).error(function(data, status){
                    $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
                    alert($scope.messageDeErro);
                });
            };
    }]);