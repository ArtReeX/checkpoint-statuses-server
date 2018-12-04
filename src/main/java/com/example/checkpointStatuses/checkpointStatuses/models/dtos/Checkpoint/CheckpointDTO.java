package com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CheckpointDTO {
    private String id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Size(min = 2, max = 100)
    private String country;

    private Integer load = 0;

    private Boolean active = true;
}
