package com.robot.navigator.component;

import com.robot.navigator.model.Mars;
import com.robot.navigator.model.Point;

public class OffGridTracker {
    private final Mars mars;
    public OffGridTracker(final Mars mars) {
        this.mars = mars;
    }

    public boolean checkOffGridCoords(final Point geoLocation) {
        return this.mars.getOffGridMarkers().contains(geoLocation);
    }

    public void add(final Point geoLocation) {
        this.mars.add(geoLocation);
    }

    public boolean isOffGrid(final Point currentLocation) {
        if (currentLocation.getX() > mars.getGridEnd().getX()
                || currentLocation.getY() > mars.getGridEnd().getY()
                || currentLocation.getX() < 0 || currentLocation.getY() < 0) {
            return true;
        }
        return false;
    }
}
