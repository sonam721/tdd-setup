package com.example.submersible.controller;

import com.example.submersible.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProbeController {

    private final ProbeService probeService = new ProbeService();
    private Grid currentGrid;

    @PostMapping("/setup")
    public ProbeStateDTO setup(@RequestBody GridSpec spec) {
        Set<Point> obstacles = spec.getObstacles().stream().collect(Collectors.toSet());
        this.currentGrid = new Grid(spec.getWidth(), spec.getHeight(), obstacles);
        probeService.setup(currentGrid, spec.getStartX(), spec.getStartY(), spec.getDirection());
        return probeService.getState();
    }

    @GetMapping("/state")
    public ProbeStateDTO getState() {
        return probeService.getState();
    }
    @PostMapping("/commands")
    public ProbeStateDTO execute(@RequestBody CommandRequest request) {
        return probeService.execute(request.getCommands());
    }
    @PostMapping("/reset")
    public String reset() {
        this.currentGrid = null;
        return "Reset complete";
    }
}