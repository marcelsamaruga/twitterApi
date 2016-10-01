## Description

The project invokes a "Search Twitter" engine using the Twitter4J API. 

## Architecture
- The architecture uses Rest API to request/response. It prints out the in JSON content-type using the GSON library.
- Spring is used for dependency injection and Spring Boot starts the application.
- Hibernate for object relational mapping in a MySQL database.
- Log4J for log error/info.
- For unit/integration tests: JUnit, Mockito and Rest Assured. To check the test coverage I have used EclEmma. The goal is to cover at least 80% of the classes.
- To search content on Twitter, Twitter4J was used.