# pettycash
Petty Cash Management Spring JPA - PostgreSQL - AngularJS
Sistema de manejo de caja chica, posee dos pantallas:
La primera pantalla permite Pedidos de dinero a caja chica para su aprobacion.
La segunda pantalla hace la administracion de la caja chica (depositos, aprobacion de retiros, revision de historicos).

Tecnologias
-----------

+ Java 1.8
+ Maven 3.3.9
+ Spring Tool Suite – Version 3.9.1.RELEASE
+ Spring Boot: 1.5.4.RELEASE
+ PostgreSQL 9.6
+ AngularJS: 1.6.0
+ BootStrap: 3.0.3 
+ Tomcat 8

Arquitectura
------------

El sistema tiene una BDD en PostgreSQL, la cual se conecta con JAVA mediante Spring JPA y utiliza la herramienta CrudRepository de Spring 
para la persistencia y CRUD en general. Existe una capa de controladores que proveen servicios REST para ser consumidos por el front end
AngularJS. 

Instalacion
-----------

1. Descargar o clonar el proyecto
2. Utilizar el STS como IDE e importar el proyecto maven.
3. Crear la BDD PostgreSQL, de acuerdo a los scripts adjuntos. El usuario y clave de la BDD se encuentra configurado en el archivo **application.properties**.
4. Compilar con Maven.
5. Configurar Tomcat 8
6. Levantar servidor con SpringBoot del STS, el cual se encargarà de levantar el front y back end.
7. En el navegador, de preferencia Chrome, ingresar a la ruta: http://localhost:8080/ para el usuario publico y http://localhost:8080/custodio para el usuario custodio.
8. Listo!