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

		<div class="row">
			<div ng-controller="custodioController" class="col-md-3">
				<div ng-show="verLogin">
					<h3>Login Custodio</h3>
					<form name="loginForm" ng-submit="submitLogin()">
						<label>Usuario</label> <input type="text" name="usuario"
							class="form-control" ng-model="usuario" /> <label>Clave</label>
						<input type="password" name="clave" class="form-control"
							ng-model="clave" />
						<button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>
				<p>{{postResultMessage}}</p>

				<div ng-show="verDeposito">
					<form name="depositoForm" ng-submit="submitDeposito()">
						<label>Monto a depositar:</label> <input type="text"
							name="montoDeposito" class="form-control"
							ng-model="montoDeposito" />
						<button type="submit" class="btn btn-primary">Depositar</button>
					</form>
				</div>



			</div>
		</div>
	</div>
</body>
</html>