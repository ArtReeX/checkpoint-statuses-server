package com.example.checkpointstatuses.checkpointstatuses.models.mapping;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint.CheckpointDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckpointMapper {
    Checkpoint checkpointDTOToCheckpoint(CheckpointDTO checkpointDTO);
}

