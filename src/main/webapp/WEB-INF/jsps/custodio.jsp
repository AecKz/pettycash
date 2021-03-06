<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Petty Cash Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
<script src="/js/angular.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
</head>
<body>
	<div class="container" ng-app="app">
		<h1>Custodio</h1>
		<div ng-controller="custodioController">
			<div class="row">
				<div ng-show="verLogin" class="col-md-3">
					<h3>Login Custodio</h3>
					<form name="loginForm" ng-submit="submitLogin()">
						<label>Usuario</label> <input type="text" name="usuario"
							class="form-control" ng-model="usuario" required /> <span
							ng-show="!loginForm.$pristine && loginForm.usuario.$error.required">El
							usuario es requerido</span> <br> <label>Clave</label> <input
							type="password" name="clave" class="form-control"
							ng-model="clave" required /> <span
							ng-show="!loginForm.$pristine && loginForm.clave.$error.required">La
							clave es requerido</span> <br>
						<button type="submit" class="btn btn-primary"
							ng-disabled="!loginForm.$valid">Login</button>
					</form>
				</div>
			</div>
			<p>{{postResultMessage}}</p>

			<div ng-show="verDeposito">
				<div class="row">
					<div class="col-md-3">
						<h3>Depositos</h3>
						<form name="depositoForm" ng-submit="submitDeposito()">
							<label>Monto a depositar:</label> <input type="number"
								name="montoDeposito" class="form-control"
								ng-model="montoDeposito" placeholder="34.66" required /> <span
								ng-show="!depositoForm.$pristine && depositoForm.montoDeposito.$error.required">El
								monto es requerido</span> <br>
							<button type="submit" class="btn btn-primary"
								ng-disabled="!depositoForm.$valid">Depositar</button>
						</form>
					</div>
					<div class="col-md-3">
						<h2>Monto actual: {{montoCuenta}}</h2>
						<button type="button" class="btn btn-primary"
							ng-click="consultaCuenta()">
							<span class="glyphicon glyphicon-refresh"></span>
						</button>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<h3>Aprobar Retiros</h3>
						<button class="btn btn-primary" ng-click="verPedidos()">Ver
							Pedidos</button>

						<div ng-show="verListaPedidos">
							<ul class="list-group">
								<li ng-repeat="pedido in listaPedidos.data"><h4
										class="list-group-item">
										<strong>Pedido {{$index+1}}</strong><br /> Nombre:
										{{pedido.nombre}}<br /> Monto: {{pedido.montoPedido}}
										<button class="btn btn-default"
											ng-click="aprobarPedido(pedido.id)">Aprobar</button>
									</h4></li>
							</ul>
						</div>
					</div>
					<div class="col-md-6">
						<h3>Historico Retiros</h3>
						<button class="btn btn-primary" ng-click="verRetiros()">Ver
							Retiros</button>

						<div ng-show="verListaRetiros">
							<ul class="list-group">
								<li ng-repeat="retiro in listaRetiros.data"><h4
										class="list-group-item">
										<strong>Retiro {{$index+1}}</strong><br /> Nombre:
										{{retiro.nombre}}<br /> Monto: {{retiro.monto}}<br /> Fecha:
										{{retiro.fechaAprueba | date: 'yyyy-MM-dd HH:mm:ss'}}
									</h4></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>