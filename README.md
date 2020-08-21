# Robot Navigator Application
-------------------
## Assumption
* Lower left coordinates (x,y) as (0,0)
## Description
Robot navigator has RobotServiceHandler and various components.
As in general Robot consists of various parts so the application tried to mimic the model in smiliar fashion.
Robot class stored the basic details of the Robot while any operations is taken care by its ServiceHandler.
* Robot: stores the current location, status and orientation. 
* RobotServiceHandler: This class provides the ability to navigate the Robot on Mars by moving forward, left or right by passing the instructions. 
To process the instructions it called a various components which are capable of understanding and providing those functionalities and uses immutability 
as much as possible since the components and service handler can be used with multiple robots.
* Components: 
    1. Navigator: Takes cares of handling the movement of robot and bearings.
    2. Validator: Takes care of validating the instructions. The functionality is not fully implemeneted due to time constraint and there could be some issues with that
    3. OffGridTracker:  Takes care of tracking the robot to prevent it from going off grid and catches the scent of other robots who are lost.
* Further improvement could be added Spring Boot and exposing this an api and introduce Spring's component dependency injection and return ServiceHandler Bean from the configuration class 
which can then be pass to the Robot object.
## Testing
Unit test can be written for each of the classes. While currently only few integration tests have been written. Few cases around the validation scenarios can be added which are missing as of now
and some edge cases.

## Technology
* Java 11 (compatability level is set to 8.) change the pom.xml incase for lower version to 8.
* lombok
* Maven
* JUnit5

## Build
`mvn clean install`
* You can also run this as an executable jar or as a Java main which will run create the Mars and Robots objects and run the application with the provided values in RobotNavigatorApplication class. 


