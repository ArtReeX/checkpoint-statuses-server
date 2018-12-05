package com.example.checkpointstatuses.checkpointstatuses.services;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint.CheckpointDTO;
import com.example.checkpointstatuses.checkpointstatuses.models.mapping.CheckpointMapper;
import com.example.checkpointstatuses.checkpointstatuses.repositories.CheckpointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckpointService {
    @Autowired
    private final CheckpointsRepository _repository;
    private final CheckpointMapper _mapper;

    @Autowired
    public CheckpointService(CheckpointMapper mapper, CheckpointsRepository repository) {
        this._mapper = mapper;
        this._repository = repository;
    }

    public ResponseEntity<List<Checkpoint>> getCheckpoints() {
        List<Checkpoint> checkpoints = _repository.findAll();
        return new ResponseEntity<>(checkpoints, HttpStatus.OK);
    }

    public ResponseEntity<Checkpoint> addCheckpoint(CheckpointDTO checkpointDTO) {
        Checkpoint checkpoint = _repository.insert(_mapper.checkpointDTOToCheckpoint(checkpointDTO));
        return new ResponseEntity<>(checkpoint, HttpStatus.CREATED);
    }

    public ResponseEntity<Checkpoint> delCheckpoint(String identifier) {
        Optional<Checkpoint> checkpoints = _repository.findById(identifier);
        System.out.println(identifier);
        if (!checkpoints.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Checkpoint checkpoint = checkpoints.get();

        _repository.delete(checkpoint);

        return new ResponseEntity<>(checkpoint, HttpStatus.OK);
    }
}
