package com.example.checkpointStatuses.checkpointStatuses.models.mapping;

import com.example.checkpointStatuses.checkpointStatuses.models.Checkpoint;
import com.example.checkpointStatuses.checkpointStatuses.models.dtos.Checkpoint.CheckpointDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckpointMapper {
    Checkpoint checkpointDTOToCheckpoint(CheckpointDTO checkpointDTO);
}

