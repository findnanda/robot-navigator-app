package com.robot.navigator.model;

import com.robot.navigator.service.RobotServiceHandler;
import com.robot.navigator.service.RobotServiceHandlerImpl;

import java.util.stream.IntStream;

import static com.robot.navigator.model.Constants.*;

public class Robot {
    private Point currentLocation;
    private String status;
    private Orientation orientation;
    private Point offGridMarker;
    private final RobotServiceHandler robotServiceHandler;

    public Robot(final Point currentLocation, final Orientation orientation, final Mars mars) {
        this.currentLocation = currentLocation;
        this.orientation = orientation;
        this.robotServiceHandler = new RobotServiceHandlerImpl(mars);
        this.status = STATUS_ACTIVE;
        mars.add(this);
    }

    public void navigate(final String instructions) {
        this.robotServiceHandler.validateInstructions(instructions);
        final char[] instruction = instructions.toCharArray();
        IntStream.range(0, instruction.length).mapToObj(i -> instruction[i])
                .map(c -> this.robotServiceHandler.navigate(c, currentLocation, orientation))
                .forEach(p -> {
                    this.updateMovement(p);
                    this.updateStatus(this.currentLocation);
                });
    }

    private void updateMovement(final Pair<Point, Orientation> pair) {
        if (!this.robotServiceHandler.hasAnyScents(pair.getFirst())) {
            this.currentLocation = pair.getFirst();
            this.orientation = pair.getSecond();
        } else {
            System.out.println("Caught robot scent..ignored movement");
        }
    }

    private void updateStatus(final Point currentLocation) {
        if (this.status.equals(STATUS_ACTIVE) && this.robotServiceHandler.isOffGrid(currentLocation)) {
            offGridMarker = currentLocation;
            this.status = STATUS_LOST;
        }
    }

    public String getFinalBearing() {
        if (offGridMarker != null) {
            this.robotServiceHandler.addOffGridCoords(offGridMarker);
        }
        StringBuilder sb = new StringBuilder(GEO_LOCATION);
        sb = sb.append(this.currentLocation).append(ORIENTATION).append(this.orientation);
        sb = this.status.equals(STATUS_LOST) ? sb.append(", ").append(STATUS_LOST) : sb;
        return sb.toString();
    }
}
