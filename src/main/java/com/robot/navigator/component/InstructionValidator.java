package com.robot.navigator.component;

import com.robot.navigator.exception.CommandException;
import com.robot.navigator.exception.InvalidLocation;
import com.robot.navigator.model.Point;

public class InstructionValidator {

    public void validateGeoLocation(final Point coordinates) {
        if (coordinates.getX() >= 50 && coordinates.getY() >= 50) {
            throw new InvalidLocation("invalid coordinates");
        }
    }

    public void validateInstruction(final String instructions) {
        if(instructions == null || (instructions != null && instructions.trim().length() < 1)) {
            throw new CommandException("Not a valid instruction");
        }
        if (instructions != null && instructions.length() > 100) {
            throw new CommandException("instructions too long");
        }
    }
}
