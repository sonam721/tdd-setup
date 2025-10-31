package com.example.submersible.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProbeStateDTO {
    private int x;
    private int y;
    private String direction;
    private List<Point> visited;
    private List<String> blockedMoves;

}
