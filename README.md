

#Assignment No. 2 (Software for managing Performance Records; Due Date Oct 24th, 2023; Upload on DIArchitect!):


- a.) Please provide a Java program that uses the interface of a control class for managing salesmen and their performance records. Do also provide a simple user interface (UI) for accessing the tool (e.g. a Scanner-based terminal / CLI, JavaFX etc. NOTE: NO Angular must be used here at this stage!!). In the backend, integrate a local MongoDB database that contains of two collections for storing general data for salesmen as well as their performance records. Please make suitable assumptions on the schema of the two collections.



### Working with maven: 
- Generate new Maven project:
```
  mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=task -DinteractiveMode=false -DartifactId=app
```
- Make jar executable:
  Add in pom.xml: ```<mainClass>task.App</mainClass>```
- alias startMongo=```"brew services start mongodb/brew/mongodb-community"```
- Port can be changed added inside: `/opt/homebrew/etc/mongod.conf`
# Ignore until here if git cloned
