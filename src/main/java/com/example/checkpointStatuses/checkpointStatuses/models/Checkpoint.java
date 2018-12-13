package com.example.checkpointStatuses.checkpointStatuses.models;

import com.example.checkpointStatuses.checkpointStatuses.models.mapping.Statistics;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "checkpoints")
public class Checkpoint {
    @Id
    private String identifier;

    private String name;
    private String road;
    private List<Statistics> statistics;
    private Boolean active;

    @Override
    public String toString() {
        return String.format(
                "Checkpoint[id='%s', name='%s', country='%s', statistics='%s', active='%s']",
                identifier, name, road, statistics, active);
    }
}
