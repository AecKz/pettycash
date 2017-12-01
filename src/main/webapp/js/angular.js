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
	$scope.verListaPedidos = false;
	$scope.verListaRetiros = false;
	$scope.idUsuario = 0;
	$scope.montoCuenta = 0;
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
				$scope.idUsuario = response.data.data.id;
			} else {
				$scope.postResultMessage = "Error!";
			}

		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

	}

	$scope.consultaCuenta = function() {
		var url = $location.absUrl() + "/consultaCuenta";
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {
			if (response.data.status == "Done") {
				$scope.montoCuenta = response.data.data.montoCuenta;
			} else {
				$scope.postResultMessage = "Error!";
			}
		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

	}

	$scope.verPedidos = function() {
		var url = $location.absUrl() + "/verPedidos";
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {
			if (response.data.status == "Done") {
				$scope.listaPedidos = response.data;
				$scope.verListaPedidos = true;
			} else {
				$scope.postResultMessage = "Error!";
			}

		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

	}
	
	$scope.verRetiros = function() {
		var url = $location.absUrl() + "/verRetiros";
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {
			if (response.data.status == "Done") {
				$scope.listaRetiros = response.data;
				$scope.verListaRetiros = true;
			} else {
				$scope.postResultMessage = "Error!";
			}

		}, function(response) {
			$scope.postResultMessage = "Fail!";
		});

	}
	$scope.aprobarPedido = function(id) {
		var url = $location.absUrl() + "/aprobarPedido";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			},

			params : {
				'id' : id
			}
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.postResultMessage = "Pedido Aprobado!";
				$scope.verListaPedidos = false;
				$scope.verListaRetiros = false;
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