package com.robot.navigator.service;

import com.robot.navigator.model.Orientation;
import com.robot.navigator.model.Pair;
import com.robot.navigator.model.Point;

public interface RobotServiceHandler {
    Pair<Point, Orientation> navigate(char instruction, Point geoLocation, Orientation orientation);

    void validateInstructions(String instructions);

    boolean hasAnyScents(Point currentLocation);

    boolean isOffGrid(Point currentLocation);

    void addOffGridCoords(Point offGridCoords);
}
