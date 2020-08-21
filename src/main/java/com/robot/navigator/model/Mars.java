package com.robot.navigator.model;

import lombok.Getter;
import lombok.Value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class Mars {
    private final Point gridStart;
    private final Point gridEnd;
    private final List<Robot> robots;
    private final Set<Point> offGridMarkers;

    public Mars(final Point gridEnd){
        this.gridStart = new Point(0,0);
        this.robots = new ArrayList<>();
        this.offGridMarkers = new HashSet<>();
        this.gridEnd = gridEnd;
    }

    public void add(final Robot robot){
        robots.add(robot);
    }

    public void add(final Point offGridCoords){
        offGridMarkers.add(offGridCoords);
    }
}
