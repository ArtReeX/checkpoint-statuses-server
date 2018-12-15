package com.example.checkpointStatuses.checkpointStatuses.models.mapping;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class Statistics {
    @NotNull
    @Size(min = 7, max = 16)
    private String ip;

    @NotNull
    @Min(0)
    private Integer cars;

    private Long date = new Date().getTime();
}
