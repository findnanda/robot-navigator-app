package com.robot.navigator.component;

import com.robot.navigator.model.Orientation;
import com.robot.navigator.model.Pair;
import com.robot.navigator.model.Point;

public class Navigator {

    private Point move(final Point currentCoordinates, final Orientation orientation) {
        Point nextLocation = null;
        switch (orientation) {
            case N:
                nextLocation = new Point(currentCoordinates.getX(), currentCoordinates.getY() + 1);
                break;
            case E:
                nextLocation = new Point(currentCoordinates.getX() + 1, currentCoordinates.getY());
                break;
            case S:
                nextLocation = new Point(currentCoordinates.getX(), currentCoordinates.getY() - 1);
                break;
            case W:
                nextLocation = new Point(currentCoordinates.getX() - 1, currentCoordinates.getY());
                break;
        }
        return nextLocation;
    }

    public Pair<Point, Orientation> moveForward(final Point currentCoordinates, Orientation currentOrientation) {
        final Point nextGeoLocation = move(currentCoordinates, currentOrientation);
        return new Pair<>(nextGeoLocation, currentOrientation);
    }

    public Pair<Point, Orientation> turnLeft(final Point currentCoordinates, final Orientation orientation) {
        Orientation newOrientation = null;
        switch (orientation) {
            case N:
                newOrientation = Orientation.W;
                break;
            case E:
                newOrientation = Orientation.N;
                break;
            case W:
                newOrientation = Orientation.S;
                break;
            case S:
                newOrientation = Orientation.E;
                break;
        }
        return new Pair<>(currentCoordinates, newOrientation);
    }

    public Pair<Point, Orientation> turnRight(final Point currentCoordinates, final Orientation orientation) {
        Orientation newOrientation = null;
        switch (orientation) {
            case N:
                newOrientation = Orientation.E;
                break;
            case E:
                newOrientation = Orientation.S;
                break;
            case S:
                newOrientation = Orientation.W;
                break;
            case W:
                newOrientation = Orientation.N;
                break;
        }
        return new Pair<>(currentCoordinates, newOrientation);
    }
}
