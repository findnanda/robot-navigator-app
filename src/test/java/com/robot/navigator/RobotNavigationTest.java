package com.robot.navigator;

import com.robot.navigator.model.Mars;
import com.robot.navigator.model.Orientation;
import com.robot.navigator.model.Point;
import com.robot.navigator.model.Robot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotNavigationTest {
    private Mars mars;

    @BeforeEach
    public void setUp() {
        mars = new Mars(new Point(5,3));
    }

    @Test
    public void testScenarioReturnToOrginalBearing() {
        Robot robot = new Robot(new Point(1,1), Orientation.E, mars);
        robot.navigate("RFRFRFRF");
        assertEquals("Geolocation: Point(x=1, y=1), Orientation: E", robot.getFinalBearing());
    }

    @Test
    public void testScenarioStatusAsLost() {
        Robot robot = new Robot(new Point(3,2), Orientation.N, mars);
        robot.navigate("FRRFLLFFRRFLL");
        assertEquals("Geolocation: Point(x=3, y=3), Orientation: N, LOST", robot.getFinalBearing());
    }

    @Test
    public void testScenarioMultiRobot() {
        Robot robot1 = new Robot(new Point(1,1), Orientation.E, mars);
        robot1.navigate("RFRFRFRF");
        robot1.getFinalBearing();
        Robot robot2 = new Robot(new Point(3,2), Orientation.N, mars);
        robot2.navigate("FRRFLLFFRRFLL");
        robot2.getFinalBearing();
        Robot robot3 = new Robot(new Point(0,3), Orientation.W, mars);
        robot3.navigate("LLFFFLFLFL");
        assertEquals("Geolocation: Point(x=2, y=3), Orientation: S", robot3.getFinalBearing());
    }

    @AfterEach
    public void tearDown() {
    }
}
