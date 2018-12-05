package com.example.checkpointstatuses.checkpointstatuses.models.mapping;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint.CheckpointDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-04T20:51:57+0300",
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

        checkpoint.setIdentifier( checkpointDTO.getIdentifier() );
        checkpoint.setName( checkpointDTO.getName() );
        checkpoint.setCountry( checkpointDTO.getCountry() );
        checkpoint.setLoad( checkpointDTO.getLoad() );
        checkpoint.setActive( checkpointDTO.getActive() );

        return checkpoint;
    }

    @Override
    public CheckpointDTO checkpointToCheckpointDTO(Checkpoint checkpoint) {
        if ( checkpoint == null ) {
            return null;
        }

        CheckpointDTO checkpointDTO = new CheckpointDTO();

        checkpointDTO.setIdentifier( checkpoint.getIdentifier() );
        checkpointDTO.setName( checkpoint.getName() );
        checkpointDTO.setCountry( checkpoint.getCountry() );
        checkpointDTO.setLoad( checkpoint.getLoad() );
        checkpointDTO.setActive( checkpoint.getActive() );

        return checkpointDTO;
    }
}
