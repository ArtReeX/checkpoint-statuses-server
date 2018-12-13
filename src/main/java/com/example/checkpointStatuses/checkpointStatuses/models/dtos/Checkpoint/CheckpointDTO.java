package com.example.checkpointStatuses.checkpointStatuses.models.dtos.Checkpoint;

import com.example.checkpointStatuses.checkpointStatuses.models.mapping.Statistics;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class CheckpointDTO {
    private String identifier;

    @NotNull
    private String name;

    @NotNull
    private String road;

    @NotNull
    private Boolean active = true;

    private List<Statistics> statistics = new ArrayList<>();
}
