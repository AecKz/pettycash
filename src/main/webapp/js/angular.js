var app = angular.module('app', []);

app.controller('postController', function($scope, $http, $location) {
	$scope.submitForm = function(){
		var url = $location.absUrl() + "postpedido";
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		var data = {
            nombre: $scope.nombre,
            montoPedido: $scope.monto
        };
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = "Pedido!";
		}, function (response) {
			$scope.postResultMessage = "Error!";
		});
		
		$scope.nombre = "";
		$scope.monto = "";
	}
});