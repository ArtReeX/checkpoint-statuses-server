package com.example.checkpointStatuses.checkpointStatuses.models.mapping;

import com.example.checkpointStatuses.checkpointStatuses.models.Checkpoint;
import com.example.checkpointStatuses.checkpointStatuses.models.dtos.Checkpoint.CheckpointDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-14T22:23:26+0300",
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
        checkpoint.setRoad( checkpointDTO.getRoad() );
        List<Statistics> list = checkpointDTO.getStatistics();
        if ( list != null ) {
            checkpoint.setStatistics( new ArrayList<Statistics>( list ) );
        }
        else {
            checkpoint.setStatistics( null );
        }
        checkpoint.setActive( checkpointDTO.getActive() );

        return checkpoint;
    }
}
