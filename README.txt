Purpose of the project

There is a water supply system. We use three parameters to describe it: starting point id,
endpoint identifier and pipe length.
This project answers the following questions:
* Is there a route between two points (id-A and id-B)?
* If the answer is yes, it will calculate the minimum route length between id-A and id-B.

Technologies stack
* Spring Boot
* Spring Data JPA
* H2 as test database
* JUnit4
* Lombok
* Univocity cvs parser
* Maven checkstyle plugin

Launch project
* Open the project in your IDE.

* Add Java SDK 11 or above in Project Structure.
* Put CSV file that describes the water pipeline system in a folder src\main\resources\ and rename it to pipeline.
Or change path.to.pipeline.file in application.properties
*If you want to use the URL path to file pipeline. Rearrange annotation @Primary from class LocalFileReaderService to UrlFileReaderService
* Put CSV file with a set of points, between which you need to find the route in a folder src\main\resources\ and rename it to routes.
Or change path.to.routes.file in src\main\resources\application.properties
* Run the project.

Test project

Use command line to control the application

You have such commands available

u -Enter this command to update pipeline

c -Enter this command to calculate the shortest routes

r -Enter this command to display results in terminal (available after the command "c")

h -Enter this command to get the entire list of commands and descriptions for them

The calculation result will be stored in a file "result" in path "src/main/resources/"

author

Bogdan Demianchuk

https://github.com/Bogdan-Demianchuk
