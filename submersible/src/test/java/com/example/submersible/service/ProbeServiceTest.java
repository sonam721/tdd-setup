package com.example.submersible.service;

import com.example.submersible.dto.Grid;
import com.example.submersible.dto.Point;
import com.example.submersible.dto.ProbeService;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeServiceTest {
    @Test
    void testMovementAndObstacle() {
        Grid grid = new Grid(5, 5, Set.of(new Point(1, 2)));
        ProbeService service = new ProbeService();
        service.setup(grid, 0, 0, "N");
        service.execute("FFRFF");
        var state = service.getState();
        assertEquals(2, state.getX());
        assertEquals(2, state.getY());
        assertEquals("E", state.getDirection());
    }
}
