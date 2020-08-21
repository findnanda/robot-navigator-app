package com.robot.navigator.model;

import lombok.Value;

@Value
public class Pair<First,Second> {
    public final First first;
    public final Second second;
}
