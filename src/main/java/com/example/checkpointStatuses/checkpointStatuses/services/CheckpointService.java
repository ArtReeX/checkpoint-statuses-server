package com.example.checkpointstatuses.checkpointstatuses.services;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.CheckpointDTO;
import com.example.checkpointstatuses.checkpointstatuses.models.mapping.CheckpointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CheckpointService {
    private final CheckpointMapper _mapper;

    @Autowired
    public CheckpointService(CheckpointMapper mapper) {
        _mapper = mapper;
    }

    public ResponseEntity<CheckpointDTO> getCheckpoints() {
        Checkpoint checkpoint = new Checkpoint();
        checkpoint.setId(1);
        checkpoint.setName("Изварино");

        CheckpointDTO result = _mapper.checkpointToCheckpointDTO(checkpoint);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<CheckpointDTO> addCheckpoint(CheckpointDTO checkpointDTO) {
        Checkpoint checkpoint = _mapper.checkpointDTOToCheckpoint(checkpointDTO);

        // Код добавления в бд

        return new ResponseEntity<>(_mapper.checkpointToCheckpointDTO(checkpoint), HttpStatus.CREATED);
    }
}
