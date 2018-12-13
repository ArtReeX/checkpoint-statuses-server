package com.example.checkpointStatuses.checkpointStatuses.models.dtos.Checkpoint;

import com.example.checkpointStatuses.checkpointStatuses.models.mapping.Statistics;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CheckpointSimpleDTO {
    @NotNull
    private String name;
    private String road;
    private Boolean active;
    private List<Statistics> statistics;
}
