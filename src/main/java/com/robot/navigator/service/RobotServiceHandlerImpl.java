package com.robot.navigator.service;

import com.robot.navigator.component.InstructionValidator;
import com.robot.navigator.component.Navigator;
import com.robot.navigator.component.OffGridTracker;
import com.robot.navigator.model.Mars;
import com.robot.navigator.model.Orientation;
import com.robot.navigator.model.Pair;
import com.robot.navigator.model.Point;

public class RobotServiceHandlerImpl implements  RobotServiceHandler {
    private static final char FORWARD = 'F';
    private static final char RIGHT = 'R';
    private static final char LEFT = 'L';

    private Navigator navigator;
    private InstructionValidator instructionValidator;
    private OffGridTracker offGridTracker;

    public RobotServiceHandlerImpl(final Mars mars){
        this.navigator = new Navigator();
        this.instructionValidator = new InstructionValidator();
        offGridTracker = new OffGridTracker(mars);
    }

    @Override
    public Pair<Point, Orientation> navigate(final char instruction, final Point geoLocation, final Orientation orientation) {
        Pair<Point, Orientation> pair = null;
        switch (instruction) {
            case LEFT:
                pair = this.navigator.turnLeft(geoLocation, orientation);
                break;
            case RIGHT:
                pair = this.navigator.turnRight(geoLocation, orientation);
                break;
            case FORWARD:
                pair = this.navigator.moveForward(geoLocation, orientation);
                break;
        }
        return pair;
    }

    @Override
    public void validateInstructions(final String instructions){
        this.instructionValidator.validateInstruction(instructions);
    }

    @Override
    public boolean hasAnyScents(final Point currentLocation){
        return this.offGridTracker.checkOffGridCoords(currentLocation);
    }

    @Override
    public boolean isOffGrid(final Point currentLocation){
        return this.offGridTracker.isOffGrid(currentLocation);
    }

    @Override
    public void addOffGridCoords(final Point offGridCoords){
        this.offGridTracker.add(offGridCoords);
    }
}
