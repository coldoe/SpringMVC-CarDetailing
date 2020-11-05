Project using:
- Java 11
- Spring
- Hibernate
- MySQL
- Thymeleaf
- Bootstrap

Setup:
- Run MySQL server.
- add database with name that is listed here => /src/main/resources/ then open file
application.properties and You will see the name of database after 'jdbc:mysql://localhost:3306/'
sign '?' ends name of database
- add also account that will have access to database and put credentials into application.properties
in spring.datasource.username and spring.datasource.password or use credentials from project.
- run  project but remember that project need Java 11

In case You didnt set Java (using IntelliJ)
- Open project File => Open => (Look for project and find pom.xml) click ok and then click open as project.
- Go File => Project Structure => Project SDK and set it to Java 11.


TODO:
- controllers and views
- spring security - 3 groups:
  user => ?
  mod => ?
  admin => ?

  - getAllClients => buttons colapse on small view

  - add in view getallclients button that will assign car only if
  there is no car, button redirects to view and lists all cars
  without owner, user clicks on dropdown list (something like that),
  clicks button and boom client has car now.

