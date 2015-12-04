    var pontoCriticoCadastroCtrl = angular.module('pontoCriticoCadastroCtrl', ['ngResource']);

    pontoCriticoCadastroCtrl.controller('pontoCriticoCadastroCtrl', ['$scope', '$http', function ($scope, $http) {
            $scope.PontoCritico = {};
            
            $scope.classe = {nome:"Classe"};
            $scope.listaClasse = [];
            $scope.inicializaDropDown = function() {
                angular.element('#dropdownTpEst a.dropdown-button').dropdown({constrain_width: false, belowOrigin: true});
                
                $http.get("../webresources/com.andepuc.preferencias").success(function (data, status){
                    $scope.listaClasse = data;
                });
            }
            
            $scope.selecionaOpcao = function(classe){
                $scope.classe = classe;
                console.log($scope.classe);
            }
           
            $scope.salvar = function(){
                
                if($scope.PontoCritico.descricao == null || $scope.PontoCritico.status == null || $scope.PontoCritico.latitude == null
                        || $scope.PontoCritico.longitude == null){
                    alert('Preencha todos os campos!');
                    return;
                }
                
                if($scope.classe.nroIntPref == null){
                    alert('Selecione uma classe para o ponto');
                    return;
                }
                
                $scope.PontoCritico.nroIntPref = $scope.classe;
                
                //$scope.PontoCritico.nroIntPonto = "";
                $http.post("../webresources/com.andepuc.ponto", $scope.PontoCritico).success(function (data){
                        alert('Cadastrado com sucesso');
                        window.location.href="../";
                }).error(function(data, status){
                    $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
                    alert($scope.messageDeErro);
                });
            };
    }]);