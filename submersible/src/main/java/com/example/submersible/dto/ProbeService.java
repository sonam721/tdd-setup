package com.example.submersible.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProbeService {
    private Grid grid;
    private int x, y;
    private String direction;
    private List<Point> visited = new ArrayList<>();
    private List<String> blockedMoves = new ArrayList<>();

    private static final List<String> DIRECTIONS = Arrays.asList("N", "E", "S", "W");
    public void setup(Grid grid, int startX, int startY, String direction) {
        this.grid = grid;
        this.x = startX;
        this.y = startY;
        this.direction = direction;
        this.visited.clear();
        this.blockedMoves.clear();
        this.visited.add(new Point(x, y));
    }
    public ProbeStateDTO execute(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'L' -> turnLeft();
                case 'R' -> turnRight();
                case 'F' -> move(true);
                case 'B' -> move(false);
                case 'S' -> {} // stay
                default -> throw new IllegalArgumentException("Invalid command: " + c);
            }
        }
        return new ProbeStateDTO(x, y, direction, visited, blockedMoves);
    }
    private void turnLeft() {
        int idx = DIRECTIONS.indexOf(direction);
        direction = DIRECTIONS.get((idx + 3) % 4);
    }

    private void turnRight() {
        int idx = DIRECTIONS.indexOf(direction);
        direction = DIRECTIONS.get((idx + 1) % 4);
    }
    private void move(boolean forward) {
        int dx = 0, dy = 0;
        switch (direction) {
            case "N" -> dy = 1;
            case "S" -> dy = -1;
            case "E" -> dx = 1;
            case "W" -> dx = -1;
        }
        if (!forward) { dx = -dx; dy = -dy; }

        int nx = x + dx;
        int ny = y + dy;
        if (!grid.isInside(nx, ny)) {
            blockedMoves.add("OUT_OF_BOUNDS:" + nx + "," + ny);
            return;
        }
        if (grid.isObstacle(nx, ny)) {
            blockedMoves.add("OBSTACLE:" + nx + "," + ny);
            return;
        }
        x = nx; y = ny;
        visited.add(new Point(x, y));
    }
    public ProbeStateDTO getState() {
        return new ProbeStateDTO(x, y, direction, visited, blockedMoves);
    }
    }
