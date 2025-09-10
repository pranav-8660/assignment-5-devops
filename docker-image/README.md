### I have dockerised a spring-boot application. This spring-boot application just reads a number and gives a response containing the tables of it until 10.

Api -> http://<ip>:<hostport=8000/desired targetport>/table/{number}
EX -> http://localhost:8000/table/56

DockerImage -> pranavv51/table-application:latest

Response -> A list of strings containing tables.
