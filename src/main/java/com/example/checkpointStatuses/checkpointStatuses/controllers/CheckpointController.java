package com.example.checkpointStatuses.checkpointStatuses.controllers;

import com.example.checkpointStatuses.checkpointStatuses.models.Checkpoint;
import com.example.checkpointStatuses.checkpointStatuses.models.dtos.Checkpoint.CheckpointDTO;
import com.example.checkpointStatuses.checkpointStatuses.models.dtos.Checkpoint.CheckpointSimpleDTO;
import com.example.checkpointStatuses.checkpointStatuses.models.mapping.Statistics;
import com.example.checkpointStatuses.checkpointStatuses.services.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/checkpoints")
public class CheckpointController {
    private final CheckpointService _checkpointService;

    @Autowired
    public CheckpointController(CheckpointService service) {
        this._checkpointService = service;
    }

    @GetMapping()
    public ResponseEntity<List<Checkpoint>> getCheckpoints() {
        return _checkpointService.getCheckpoints();
    }

    @GetMapping(params = {"identifier"})
    public ResponseEntity<Checkpoint> getCheckpoints(@RequestParam("identifier") String identifier) {
        return _checkpointService.getCheckpoints(identifier);
    }

    @PostMapping()
    public ResponseEntity<Checkpoint> addCheckpoint(@RequestBody @Valid CheckpointDTO checkpointDTO) {
        return _checkpointService.addCheckpoint(checkpointDTO);
    }

    @PatchMapping(params = {"identifier"})
    public ResponseEntity<Checkpoint> editCheckpoint(@RequestParam("identifier") String identifier,
                                                    @RequestBody @Valid CheckpointSimpleDTO checkpointSimpleDTO) {
        return _checkpointService.editCheckpoint(identifier, checkpointSimpleDTO);
    }

    @DeleteMapping(params = {"identifier"})
    public ResponseEntity<List<Checkpoint>> delCheckpoint(@RequestParam("identifier") String identifier) {
        return _checkpointService.delCheckpoint(identifier);
    }

    @PostMapping(path = "/statistics", params = {"identifier"})
    public ResponseEntity<Checkpoint> addStatisticsCheckpoint(@RequestParam("identifier") String identifier,
                                                              @RequestBody @Valid Statistics statistics) {
        System.out.println(statistics);
        return _checkpointService.addStatisticsCheckpoint(identifier, statistics);
    }
}
