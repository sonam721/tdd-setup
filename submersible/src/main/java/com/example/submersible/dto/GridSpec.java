package com.example.submersible.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GridSpec {
    private int width;
    private int height;
    private List<Point> obstacles;
    private int startX;
    private int startY;
    private String direction;
}
