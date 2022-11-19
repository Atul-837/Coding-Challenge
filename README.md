# IN THIS APPLICATION, REACT IS USED FOR FRONTEND AND JAVA/SPRINGBOOT IS USED FOR BACKEND.

# FIRSTLY, INSTRUCTIONS TO CONFIGURE THE FRONTEND i.e. REACT
## PLEASE FOLLOW SOME BASIC STEPS TO RUN AND BUILD THE FRONTEND APPLICATION:

### PLEASE PUT FRONTEND FOLDER/REPO INSIDE MAIN PROJECT (IF NOT ALREADY THERE) AS PATHS FOR DOCKER CONTAINERS ARE SET UP ACCORDINGLY

* Make sure npm/node.js installed on the system. Command is npm -v to check npm status
* Filename: package.json contains all dependencies to build this project
* Run command - npm install to install all necessary dependencies
* Then run command - npm run build to build the project
* To start the development server - npm start
* Frontend folder has Dockerfile that includes configuration for react component of this application.


### This will start the REACT server and the port exposed is 3000.

# SECONDLY, INSTRUCTIONS TO CONFIGURE THE BACKEND:
## PLEASE FOLLOW THE INSTRUCTIONS BELOW:

* First and foremost, project is using maven as a build automation tool. 
* Please check the pom.xml file and make sure it is updated and loaded.
* Mark the project as maven project and java as a source root directory if not so.
* Please run the command MVN CLEAN INSTALL / mvn clean install. It will clean any previously compiled files and compile the file again for a fresh start
* Dockerfile for java is there containing necessary configuration to build the project and run it in docker environment.
* You can run the application by managing the run configuration.
* Backend application is exposed at port 8090

# STEPS TO RUN APPLICATION IN DOCKER ENVIRONMENT:
* Check whether docker is installed using docker -version.
* Project has docker-compose.yaml file that include configuration to set up containers and images for this project.
* Run command docker compose -f "<docker-compose.yaml>" up to create the respective container.
* Needs a control of the container so start the containers in detach mode by executing commands:
  ** docker compose -f "<docker-compose.yaml with path>" up -d 
  ** docker exec -it <container-name> or <container-id> bash
* Command: docker ps to get info of all the existing containers
