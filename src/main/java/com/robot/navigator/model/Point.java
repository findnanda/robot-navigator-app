package com.robot.navigator.model;

import lombok.ToString;
import lombok.Value;

import java.util.function.Function;

@Value
public class Point {
    private final int x;
    private final int y;
}
