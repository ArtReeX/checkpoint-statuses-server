package com.example.checkpointstatuses.checkpointstatuses.services;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint.CheckpointDTO;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint.CheckpointSimpleDTO;
import com.example.checkpointstatuses.checkpointstatuses.models.mapping.CheckpointMapper;
import com.example.checkpointstatuses.checkpointstatuses.models.mapping.Statistics;
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

    public ResponseEntity<Checkpoint> getCheckpoints(String identifier) {
        if (!_repository.existsById(identifier)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_EXTENDED);
        }

        Optional<Checkpoint> checkpoints = _repository.findById(identifier);
        Checkpoint checkpoint = checkpoints.get();
        return new ResponseEntity<>(checkpoint, HttpStatus.OK);
    }

    public ResponseEntity<Checkpoint> addCheckpoint(CheckpointDTO checkpointDTO) {
        Checkpoint checkpoint = _repository.insert(_mapper.checkpointDTOToCheckpoint(checkpointDTO));
        return new ResponseEntity<>(checkpoint, HttpStatus.CREATED);
    }

    public ResponseEntity<Checkpoint> editCheckpoint(String identifier, CheckpointSimpleDTO checkpointSimpleDTO) {
        if (!_repository.existsById(identifier)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_EXTENDED);
        }

        Optional<Checkpoint> checkpoints = _repository.findById(identifier);
        Checkpoint checkpoint = checkpoints.get();


        if (checkpointSimpleDTO.getName() != null) {
            checkpoint.setName(checkpointSimpleDTO.getName());
        }
        if (checkpointSimpleDTO.getRoad() != null) {
            checkpoint.setRoad(checkpointSimpleDTO.getRoad());
        }
        if (checkpointSimpleDTO.getActive() != null) {
            checkpoint.setActive(checkpointSimpleDTO.getActive());
        }
        if (checkpointSimpleDTO.getStatistics() != null) {
            checkpoint.setStatistics(checkpointSimpleDTO.getStatistics());
        }

        checkpoint = _repository.save(checkpoint);
        return new ResponseEntity<>(checkpoint, HttpStatus.OK);
    }

    public ResponseEntity<List<Checkpoint>> delCheckpoint(String identifier) {
        List<Checkpoint> checkpoints;
        if (!_repository.existsById(identifier)) {
            checkpoints = _repository.findAll();
            return new ResponseEntity<>(checkpoints, HttpStatus.NOT_EXTENDED);
        }
         _repository.deleteById(identifier);
        checkpoints = _repository.findAll();
        return new ResponseEntity<>(checkpoints, HttpStatus.OK);
    }

    public ResponseEntity<Checkpoint> addStatisticsCheckpoint(String identifier, Statistics statistics) {
        if (!_repository.existsById(identifier)) {
            return new ResponseEntity<>(null, HttpStatus.NOT_EXTENDED);
        }

        Optional<Checkpoint> checkpoints = _repository.findById(identifier);
        Checkpoint checkpoint = checkpoints.get();

        List<Statistics> statisticsList = checkpoint.getStatistics();
        statisticsList.add(statistics);

        checkpoint.setStatistics(statisticsList);
        checkpoint = _repository.save(checkpoint);

        return new ResponseEntity<>(checkpoint, HttpStatus.OK);
    }
}
