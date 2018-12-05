package com.example.checkpointstatuses.checkpointstatuses.models.dtos.checkpoint;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class CheckpointDTO {
    private String identifier;

    @NotNull
    private String name;

    @NotNull
    private String country;

    @NotNull
    @Min(0)@Max(100)
    private Integer load = 0;

    @NotNull
    private Boolean active = true;
}
