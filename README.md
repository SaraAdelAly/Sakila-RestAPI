# Sakila-restAPI
The Sakila Database REST API provides a RESTful web service for accessing the data stored in the Sakila database. The Sakila database is a sample database that represents a DVD rental store, with tables such as film, actor, customer, etc. The API allows users to perform CRUD (Create, Read, Update, Delete) operations on the data stored in the Sakila database using standard HTTP methods.

# Getting Started
1. Download and Import Sakila Database: You need to download the Sakila database and import it into your database server. You can download the Sakila database from the MySQL website (https://dev.mysql.com/doc/index-other.html) or from other sources that provide the sample database.

2. Setup API Environment: Clone the Sakila Database SOAP API repository from the GitHub repository (https://github.com/SaraAdelAly/Sakila.git) to your local development environment. 
3. Create sakila dataBase in MySQL server.
4. setup you username and password on persistence.xml file.
5. run your apache maven to enable the server.
6. deploy your project with this command: mvn clean install tomcat7:deploy. 

The used technology in this project:
- Maven
- Tomcat
- Hibernate
- JAX-RS
- MySQL
- postman

# ENDPoints

The following link contains all end points which are avilable in this project

https://documenter.getpostman.com/view/26735021/2s93Y3uLBb

you can find the base URL on "http://localhost:8888/sakila/webapi"


 
