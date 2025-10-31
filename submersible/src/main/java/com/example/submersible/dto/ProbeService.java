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

}
