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
		<h1>Petty Cash Management</h1>

		<div class="row">
			<div ng-controller="postController" class="col-md-3">
				<form name="pedidoForm" ng-submit="submitForm()">
					<label>Nombre</label>
					<input type="text" name="nombre" placeholder="Pablo" class="form-control" ng-model="nombre" required/>
					<span ng-show="!pedidoForm.$pristine && pedidoForm.nombre.$error.required">El nombre es requerido</span>
					<br>
					<label>Monto</label>
					<input type="number" name="monto" placeholder="55.46" class="form-control" ng-model="monto" required/>
					<span ng-show="!pedidoForm.$pristine && pedidoForm.monto.$error.required">El monto es requerido</span>
					<br>
					<button type="submit" class="btn btn-primary" ng-disabled="!pedidoForm.$valid">Pedir</button>
				</form>
				<p>{{postResultMessage}}</p>
			</div>
		</div>
	</div>
</body>
</html>