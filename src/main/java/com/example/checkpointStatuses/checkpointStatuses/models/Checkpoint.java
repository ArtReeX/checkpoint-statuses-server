package com.example.checkpointstatuses.checkpointstatuses.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "checkpoints")
public class Checkpoint {
    @Id
    private String identifier;

    private String name;
    private String country;
    private Integer load;
    private Boolean active;

    @Override
    public String toString() {
        return String.format(
                "Checkpoint[id='%s', name='%s', country='%s', load='%s', active='%s']",
                identifier, name, country, load, active);
    }
}
