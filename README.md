For building and running the application you need:

# Supported Versions

* 1.8
* 1.11
* 1.15

# Build (Maven)

Java 
* [Maven](http://maven.apache.org/) version 3.6.3

## Build the application 

#Build the solution by using the following command
```
mvn clean install -DskipTests -q assembly:single

```
Once the `maven` command to build the solution is executed, then we run the following command to execute the code.

```
java -jar <path_to>/geektrust.jar <absolute_path_to_input_file>
```

# Unit tests


Execute the unit tests using the command

```
mvn clean test
mvn jacoco:report 


```
