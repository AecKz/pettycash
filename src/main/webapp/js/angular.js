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

app.controller('custodioController', function($scope, $http, $location) {
	$scope.verLogin = true;
	$scope.verDeposito = false;
	$scope.idUsuario = 0;
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
				debugger;
				$scope.postResultMessage = "Logeado!";
				$scope.verLogin = false;
				$scope.verDeposito = true;
				$scope.idUsuario = response.data.data.id;
			} else {
				$scope.postResultMessage = "Error!";
			}

		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

	}
	
	$scope.submitDeposito = function() {
		var url = $location.absUrl() + "/postdeposito";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		debugger;
		var data = {
			idUsuario : $scope.idUsuario,
			montoDeposito : $scope.montoDeposito
		};

		$http.post(url, data, config).then(function(response) {
			$scope.postResultMessage = "Depositado!";
		}, function(response) {
			$scope.postResultMessage = "Error!";
		});

		$scope.montoDeposito = "";
	}
});