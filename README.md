# microservice-examples
This is a collection of basic examples about how to implement a Microservice on different platforms. The examples can be used as templates for own projects on different environments:

**[Hello-World Example Jakarta EE 9](./jakarta9/README.md)**

A Microservice is build in JDK 11 and based on Jakarta EE 9 and Microprofile 3.2. The project runs with Docker on Payara or Wildfy. 

**[Hello-World Example Jakarta EE 8](./jakarta8/README.md)**

A Microservice is build in JDK 1.8 and based on Jakarta EE 8 and Microprofile 3.2. The project runs with Docker on Payara or Wildfy. 

**[Hello-World Example Spring Boot 2.6.2](./springboot/README.md)**

A Microservice is build in JDK 11 and based Spring Boot 2.6.2. The project can be started form Java Main class BaseApplication or with the SpringBoot uber jar. 


	
## The Rest API

The Microservice proivdes 2 simple Rest API endpoints:

### The Ping Service

The Ping resource just returns a ping message with a timestamp:

	http://localhost:8080/api/ping


### The Address Service

The Address resource is an example how to deal with POJOs in a Rest API method.

	http://localhost:8080/api/data/address/123

The Service creates a simple Address Java Object and returns the object data requested in JSON or XML

## Swagger API

All implementations include a Swagger OpenAPI documentation accessible from your web browser. The the project details how to access the Swagger API for different platforms. 

<img src="./doc/images/swagger_ui.png" />


## Logging

All implementations use the standard java logger `java.util.logging.Logger` to print log messages to the server log file. So there is not extra logging framework needed.

## Health Service

The Jakarta EE implementations also include a Health API example. 

		http://localhost:8080/health
	
## Inject Configuration Params via Environment variables

All implementations are including a configuration example. 

The Ping Service reads in each request the Environment variable `MAIL_HOST` and prints out the value into the server log file.
This is an example how you can externalize configuration to environment variables. For example in this way you can set different values for different environments. 


# Maven Archetype

You can also generate a Maven Archetype out from each of the projects to be used to create custom projects:

	$ mvn archetype:create-from-project

This will generate a new archetype from the current project.
Next navigate to target\generated-sources\archetype and run:

	$ mvn install archetype:update-local-catalog

Now the new archetype is installed locally. You can create a new project now with:

	$ cd my-project-folder	
	$ mvn archetype:generate -DarchetypeCatalog=local

Choose the number of your generated project.

Or run:

	$  mvn archetype:generate -DarchetypeCatalog=local -DarchetypeGroupId=com.rsoika  -DarchetypeArtifactId=hello-world-jakarta9-archetype
