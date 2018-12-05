package com.example.checkpointstatuses.checkpointstatuses.controllers;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint.CheckpointDTO;
import com.example.checkpointstatuses.checkpointstatuses.services.CheckpointService;
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

    @GetMapping("/getCheckpoints")
    public ResponseEntity<List<Checkpoint>> getCheckpoints() {
        return _checkpointService.getCheckpoints();
    }

    @PostMapping("/addCheckpoint")
    public ResponseEntity<Checkpoint> addCheckpoint(@RequestBody @Valid CheckpointDTO checkpointDTO) {
        return _checkpointService.addCheckpoint(checkpointDTO);
    }

    @GetMapping("/delCheckpoint")
    public ResponseEntity<Checkpoint> delCheckpoint(@RequestParam("identifier") String identifier) {
        return _checkpointService.delCheckpoint(identifier);
    }
}
