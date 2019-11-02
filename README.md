# clienteTestWs

## Resumen ##
El repositorio alberga las fuentes de Cliente WS implementado con spring framework y desplegado en AWS.
Para mayor informacion consultar: http://clienteretoaws-env.jgirjcwizt.us-east-2.elasticbeanstalk.com:9001/swagger-ui.html

## Instalación ##

### Pre - Requisitos ###

* Sistema Operativo: Windows 7 o mayor
+ [Eclipse Luna](https://www.eclipse.org/ide/). Tomar en consideracion la instalación de los siguientes plugins:
    * [M2Eclipse](http://www.eclipse.org/m2e/)
    * [m2e-connector for maven-dependency-plugin](https://marketplace.eclipse.org/content/m2e-connector-maven-dependency-plugin) que se encuentra en Eclipse Market.
	* [Spring Tools 4-plugin](https://marketplace.eclipse.org/content/spring-tools-4-spring-boot-aka-spring-tool-suite-4) que se encuentra en Eclipse Market.
	
+ [Git For Windows](https://msysgit.github.io/). Considerar adicionalmente un cliente git como:
    * [Source Tree](https://www.sourcetreeapp.com/)
    * [Tortoise Git](https://code.google.com/p/tortoisegit/)
	
### Instalación de Ambiente local ###

1. El proyecto ya cuenta con el conector H2 database, para utilizarlo solo se tiene de renombrar el archivo import_bkp.sql a import.sql
2. Adicional comentar las siguiente propiedades en el archivo application.properties:

		spring.datasource.url=jdbc:mysql://database-reto.cggzatvslfsy.us-east-2.rds.amazonaws.com:3306/db_reto
		spring.datasource.username=tjpizarroip
		spring.datasource.password=kyokasuigetsu
		spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
		spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
		#spring.jpa.hibernate.ddl-auto=create
		spring.jpa.hibernate.ddl-auto=update
		logging.level.org.hibernate.SQL=debug

### Configuración de Base de Datos ###

La base de datos esta creada el AWS por RDS, caso de perdida de conexion con el ambiente se puede utilizar la siguiente linea en docker para correr un contenedor con mysql:

		docker run --name=mysql1 -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_ROOT_HOST=% mysql/mysql-server:5.7

Cambiando las siguiente propiedades en el rchivo application.properties

		spring.datasource.url=jdbc:mysql://localhost:3306/db_reto
		spring.datasource.username=root
		spring.datasource.password=123456
		spring.jpa.hibernate.ddl-auto=create

* Cabe resaltar es necesario crear la BD db_reto


### Test - Pruebas ###

Se añadio al repositorio el archivo [Reto-Cliente.postman_collection.json](https://github.com/tjpizarroip/clienteTestWs/blob/master/Reto-Cliente.postman_collection.json ), que contiene la collecion de postman para ser importado con los endpoint solicitados.


### Administrador del Repositorio ###

Javier Pizarro Ipanaque

* tjpizarroip91@gmail.com
* Celular: 966125828


