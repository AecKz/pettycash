var app = angular.module('app', []);

app.controller('postController', function($scope, $http, $location) {
	$scope.submitForm = function() {
		var url = $location.absUrl() + "postpedido";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		var data = {
			nombre : $scope.nombre,
			montoPedido : $scope.monto
		};

		$http.post(url, data, config).then(function(response) {
			$scope.postResultMessage = "Pedido!";
		}, function(response) {
			$scope.postResultMessage = "Error!";
		});

		$scope.nombre = "";
		$scope.monto = "";
	}
});

app.controller('loginController', function($scope, $http, $location) {
	$scope.verLogin = true;
	$scope.verDeposito = false;
	$scope.submitLogin = function() {
		var url = $location.absUrl() + "/login";
		var verLogin = true;
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		var data = {
			usuario : $scope.usuario,
			clave : $scope.clave
		};

		$http.post(url, data, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.postResultMessage = "Logeado!";
				$scope.verLogin = false;
				$scope.verDeposito = true;
				
			} else {
				$scope.postResultMessage = "Error!";
			}

		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

	}
});