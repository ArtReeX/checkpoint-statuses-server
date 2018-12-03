package com.example.checkpointstatuses.checkpointstatuses.models.mapping;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.CheckpointDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-03T20:26:31+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class CheckpointMapperImpl implements CheckpointMapper {

    @Override
    public Checkpoint checkpointDTOToCheckpoint(CheckpointDTO checkpointDTO) {
        if ( checkpointDTO == null ) {
            return null;
        }

        Checkpoint checkpoint = new Checkpoint();

        checkpoint.setId( checkpointDTO.getId() );
        checkpoint.setName( checkpointDTO.getName() );

        return checkpoint;
    }

    @Override
    public CheckpointDTO checkpointToCheckpointDTO(Checkpoint checkpoint) {
        if ( checkpoint == null ) {
            return null;
        }

        CheckpointDTO checkpointDTO = new CheckpointDTO();

        checkpointDTO.setId( checkpoint.getId() );
        checkpointDTO.setName( checkpoint.getName() );

        return checkpointDTO;
    }
}
