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

    @CrossOrigin()
    @GetMapping()
    public ResponseEntity<List<Checkpoint>> getCheckpoints() {
        return _checkpointService.getCheckpoints();
    }

    @CrossOrigin()
    @GetMapping(params = {"identifier"})
    public ResponseEntity<Checkpoint> getCheckpoints(@RequestParam("identifier") String identifier) {
        return _checkpointService.getCheckpoints(identifier);
    }

    @CrossOrigin()
    @PostMapping()
    public ResponseEntity<Checkpoint> addCheckpoint(@RequestBody @Valid CheckpointDTO checkpointDTO) {
        return _checkpointService.addCheckpoint(checkpointDTO);
    }

    @CrossOrigin()
    @PatchMapping(params = {"identifier"})
    public ResponseEntity<Checkpoint> editCheckpoint(@RequestParam("identifier") String identifier,
                                                    @RequestBody @Valid CheckpointSimpleDTO checkpointSimpleDTO) {
        return _checkpointService.editCheckpoint(identifier, checkpointSimpleDTO);
    }

    @CrossOrigin()
    @DeleteMapping()
    public ResponseEntity<List<Checkpoint>> delCheckpoint() {
        return _checkpointService.delCheckpoint();
    }

    @CrossOrigin()
    @DeleteMapping(params = {"identifier"})
    public ResponseEntity<List<Checkpoint>> delCheckpoint(@RequestParam("identifier") String identifier) {
        return _checkpointService.delCheckpoint(identifier);
    }

    @CrossOrigin()
    @PostMapping(path = "/statistics", params = {"identifier"})
    public ResponseEntity<Checkpoint> addStatisticsCheckpoint(@RequestParam("identifier") String identifier,
                                                              @RequestBody @Valid Statistics statistics) {
        return _checkpointService.addStatisticsCheckpoint(identifier, statistics);
    }
}
