var pontoCriticoViewCtrl = angular.module('pontoCriticoViewCtrl', ['ngResource']);

pontoCriticoViewCtrl.controller('pontoCriticoViewCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.pontos = [];
    $scope.ponto = [];

    $scope.salvaParaAlteracao = function(ponto){
        $scope.ponto = ponto;
    };
    
    $scope.alterar = function(){
        if($scope.ponto.descricao == null || $scope.ponto.status == null || $scope.ponto.latitude == null
                        || $scope.ponto.longitude == null){
                    alert('Preencha todos os campos!');
                    return;
        }
        
        $http.post("../webresources/com.andepuc.ponto", $scope.ponto.nroIntPonto, $scope.ponto).success(function (data){
                alert('Cadastrado com sucesso');
                window.location.href="../";
        }).error(function(data, status){
            $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
            alert($scope.messageDeErro);
        });
    };
    
    $scope.aprovar = function(ponto){
        ponto.status = 'OK';
        console.log(ponto);
        $http.post("../webresources/com.andepuc.ponto/", ponto).success(function (data){
                alert('Aprovado com sucesso');
                 window.location.href="../views/visualizarPontoCritico.html";
        }).error(function(data, status){
            $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
            alert($scope.messageDeErro);
        });
    };
    
    $scope.reprovar = function(ponto){
        
        $http.delete("../webresources/com.andepuc.ponto/", ponto.nroIntPonto).success(function (data){
                alert('Reprovado com sucesso');
        }).error(function(data, status){
            $scope.messageDeErro = "Aconteceu um problema ao cadastrar o acesso : "+data; 
            alert($scope.messageDeErro);
        });
    };

    $scope.carregarPontosCriticos = function(){
        $http.get("../webresources/com.andepuc.ponto").success(function (data, status){
            $scope.pontos = data;
        });
    };
    
    
}]);