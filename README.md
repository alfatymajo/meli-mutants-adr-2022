


# Meli - Challenge Tecnico BE - Mutantes
#### Por Alexis Rodriguez

*********
![alt text](https://github.com/alfatymajo/meli-mutants-adr-2022/blob/main/xmen-portada.png "Portada Xmen")
*********

* Documento con la consigna del proyecto: [Challenge MeLi BE- Mutantes.pdf](https://github.com/alfatymajo/meli-mutants-adr-2022/blob/main/Challenge%20MeLi%20BE-%20Mutantes.pdf)

*********

## Instalacion requerida

+ **Java 1.8**
+ **STS (Spring Tool Suite)** 
+ **Mysql Server** 

# Herramientas\Tecnologías

| Nombre        | Descripción   |
| ------------- |:-------------:|
| **Java 8**      | Lenguaje de utilizado |
| **Spring Tool Suite**      | IDE de desarrollo      |
| **Spring Initializr** |  Herramienta web para armado de proyecto base      |
| **Maven** |  Gestor de dependencias\Paquetes      |
| **Spring Data** |  Herramienta para la interaccion con la base de datos      |
| **Spring Web** |  Herramienta para la construccion de aplicaciones Web      |
| **OpenApi** |  Herramienta para documentacion de la api     |
| **Git**      | Versionado      |
| **GitHub**      | Repositorio      |
| **Mysql**      | Sistema de gestión de Bases de Datos relacionales     |
| **JUnit**      | Framework de test automaticos/unitarios     |

*********

# Nivel 1 - Creación del metodo principal.

En la ruta **Files/Nivel-1** del presente repositorio se encuentra el proyecto con el codigo fuente correspondiente al primer requisito. Asimismo el proyecto se encuentra compilado en un archivo **.JAR** para luego ser importado y reutilizado para la consigna de los nivel 2 y 3.

Algunas aclaraciones de la consigna.

En base al ejemplo expuesto en el pdf con las consignas y en el texto que dice "Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.", es que se toman en cuenta para el calculo todas las lineas horizontales, verticales y la diagonal principal de la matriz, como se ve en el ejemplo. Ademas como se indico que el **ADN** corresponde a una matriz **NxN**, entonces se toman como validas solamente aquellas representaciones de ADN correspondientes a matrices cuadradas.

## Instrucciones Nivel 1

Para utilizar el programa deben descomprimir el ZIP del proyecto (**MELI_MUTANTS**) en un Workspace de Eclipse o de alguna IDE basada en Eclipse. Para realizar unas simples pruebas bastara con ejecutar la siguiente clase, contenedora del metodo `main()`:

```java
SimpleTest.Class

```

La misma ejecutara un caso aleatorio entre unos pocos ya predefinidos. Si se quiere ejecutar mas casos se pueden ejecutar los test restantes o el **Test Suite**, para ejecutar todos los test de una sola vez. Los mismos se encuentran configurados con el framework **JUnit**.

# Nivel 2 y 3 - Creación de API REST Con integracion a Base de Datos

En el raiz del repositorio se encuentra todo la estructura del proyecto para los niveles 2 y 

La **API** en cuestión esta construida con **Spring Boot**, por lo que para que puedan levantar el proyecto los mas recomendable seria usar la IDE **Spring Tool Suite** que trae todo lo necesario para poder correr la aplicacion. 

*********

## Detalles del servicio

| DESCRIPCION  | PETICION  | HEADER  | RESPUESTA
| ------ | ------ | ------ | ------ |
| Servicio Mutant | **POST** | **Content-Type: application/json** | Caso OK devuelve un **HTTP 200** (si es mutante) o **HTTP 403** en caso contrario.

Cuando se logre levantar la aplicacion, para usar el servicio /mutant/ se debera realizar mediante el siguiente endpoint: **http://localhost:8080/api/mutant**. Este servicio solo atiende peticiones **POST**.

La API se encuentra actualmente implementada en el hosting cloud **Heroku**, con el mismo comportamiento presentado en el entorno local y se puede acceder mediante la siguiente URL:

**https://meli-mutants-adr2022.herokuapp.com/api/mutant**

Para poder correr la aplicacion en un ambiente local deberan tener instalado **Mysql Server**, con una instancia activa. Se debe definir la url de conexion, el usuario y la contraseña en el archivo **application.properties**, ubicado en la ruta **src\main\resources**. En la carpeta **Files** se encuentra el script SQL Necesario para armar la estructura de tablas necesaria para persistir y consultar los datos.

*********

En la misma instancia del desafio se creo un servicio para traer al cliente las estadisticas de **ADNs** consultados en la aplicación, el cual se describe a continuación:

| DESCRIPCION  | PETICION  | RESPUESTA
| ------ | ------ | ------ |
| Servicio Stats | **GET** | Devuelve las estadisticas de ADN consultados en un String con formato JSON.

De forma local se usara la siguiente URL para probarlo: **http://localhost:8080/api/stats**

La dirección para utilizar el servicio implementado en **Heroku** es la siguiente:

**https://meli-mutants-adr2022.herokuapp.com/api/stats**


Tambien se utilizo **OpenApi** para realizar una documentacion simple de la api, a la cual se puede acceder mediante el siguiente enlace:

**https://meli-mutants-adr2022.herokuapp.com/api-docs-ui.html**



Sin ir mas lejos hasta aqui llego el instructivo y detalle de como utilizar la aplicación propuesta como ejercio tecnico para **MELI**.

**Atte**
**Alexis Damian Rodriguez**