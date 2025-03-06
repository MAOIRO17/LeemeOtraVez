# LéemeOtraVez

LéemeOtraVez es un sitio web diseñado para amantes de la lectura que buscan una alternativa más económica y sostenible para adquirir libros. Su propuesta se centra en la venta de libros de segunda mano, permitiendo a los usuarios comprar libros usados ​​a precios más asequibles respecto al coste de los libros nuevos.


## Instalación
  Estos son los comandos para poder desplegar el proyecto en local desde Github:

```
git clone https://github.com/MAOIRO17/LeemeOtraVez.git
mvn clean install 
mvn spring-boot:run
```
## Instalación de BD
  Estos son los pasos para poder desplegar la BD en MySql Workbench desde Github:

```
1-Abrir MySQL Workbench y conectarse al servidor.
2-Crear la base de datos si el archivo .sql no la incluye.
3-Importar el archivo SQL:
    Ir a Server → Data Import.
    Seleccionar Import from Self-Contained File y elegir el .sql.
    Seleccionar la base de datos y hacer clic en Start Import.
4-Verificar que las tablas se hayan importado correctamente en Schemas.

```    
## Tecnologías
Las tecnologías utilizadas son:

**Backend:** Java Spring y MySQL

**Frontend:** JavaScript,Jquery y Bootstrap


## Estructura

```
├── src/main/java/com/Proyecto
│   ├── Config/
│   ├── controller/
│   ├── model/
│   ├── Repository/
│   ├── service/
│   ├── ProyectoApplication.java
│   
├── src/main/resources
│   ├── static/
│   ├── templates/
│   ├── application.properties
├── pom.xml
```
