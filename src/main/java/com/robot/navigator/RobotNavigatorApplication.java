package com.robot.navigator;

import com.robot.navigator.model.Mars;
import com.robot.navigator.model.Orientation;
import com.robot.navigator.model.Point;
import com.robot.navigator.model.Robot;

public class RobotNavigatorApplication {

    public static void main(String [] args){
        System.out.println("***** Starting Robot Navigator App ************");
        final Mars mars = buildMars(new Point(5, 3));

        Robot robot1 = createAndInitialiseRobot(new Point(1,1), Orientation.E, mars);
        Robot robot2 = createAndInitialiseRobot(new Point(3,2), Orientation.N, mars);
        Robot robot3 = createAndInitialiseRobot(new Point(0,3), Orientation.W, mars);

        robot1.navigate("RFRFRFRF");
        System.out.println("Robot 1 = "+robot1.getFinalBearing());

        robot2.navigate("FRRFLLFFRRFLL");
        System.out.println("Robot 2 = "+robot2.getFinalBearing());

        robot3.navigate("LLFFFLFLFL");
        System.out.println("Robot 3 = "+robot3.getFinalBearing());
        System.out.println("***** Shutting down Robot Navigator App ************");
    }

    private static Robot createAndInitialiseRobot(final Point currentGeoLocation, final Orientation orientation, final Mars mars){
        return new Robot(currentGeoLocation, orientation, mars);
    }

    private static Mars buildMars(final Point upperCoordinates){
        return new Mars(upperCoordinates);
    }
}
