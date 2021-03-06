# Hello World Example - Scheduling

This is a Microservice example running on Jakarta EE 8 providing a scheduler service. 

A scheduler service is a container managed service that calls a method on a time-based event. As an example, a service may have to run every hour to collect some  statistics.

## The ManagedScheduledExecutorService

The ManagedScheduledExecutorService provides a lightweight scheduling pattern in Jakarta EE for submitting delayed or periodic tasks for execution. 
In contract to the Jakarta EE TimerService it does not support features like transaction support or full lifecycle operations (create, read, cancel timers), which are supported only by EJB Timers. But for most simple periodic tasks the ManagedScheduledExecutorService is strait forward solution.



## Build

The project is based on Docker. To build the project you can run:

	$./buildAndRun.sh

This will run a Maven build, creating a new Docker image and starting the server

To manually build and run you can run the following commands:


	$ mvn clean package && docker build -t com.ralph.microprofile/hello-world .
	$ docker run -d -p 8080:8080 --name hello-world com.ralph.microprofile/hello-world 
	


	
## The Rest API

The Microservice proivdes 2 simple Rest API endpoints:

### The Ping Service

The Ping resource just returns a ping message with a timestamp:

	http://localhost:8080/api/ping


### The Address Service

The Address resource is an example how to deal with POJOs in a Rest API method.

	http://localhost:8080/api/data/address/123

The Service creates a simple Address Java Object and returns the object data requested in JSON or XML
	
	

### Swagger	

The Microservice also includes a Swagger UI, so you can test your services from your Web Browser:

	http://localhost:8080/api/openapi-ui/
	

<img src="../doc/images/swagger_ui.png" />	


## Logging

The project uses the standard java logger `java.util.logging.Logger` to print log messages to the server log file. So there is not extra logging framework needed.
	
## Health 

A Healthcheck Service endpoint allows you to monitor the status of your application. Based on Jakarta EE 8 and [Eclipse Microprofile](https://microprofile.io/) the Microservice provides an example Healthcheck endpoint:

On Wildfly (default): 

	http://localhost:9990/health
	
On Payara: 

	http://localhost:8080/health

	
Learn more about the [Microprofile Health API](https://microprofile.io/project/eclipse/microprofile-health).	
	
## Inject Configuration Params via Environment variables

The project includes a configuration example. 

The Ping Service reads in each request the Environment variable `MAIL_HOST` and prints out the value into the server log file.
This is an example how you can externalize configuration to environment variables. For example in this way you can set different values for different environments. 

Learn more about the [Microprofile Config API](https://microprofile.io/project/eclipse/microprofile-config).



# Build your own Project with a Maven Archetype

You can generate a Maven Archetype out from this project to be used to create a custom project:

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

	