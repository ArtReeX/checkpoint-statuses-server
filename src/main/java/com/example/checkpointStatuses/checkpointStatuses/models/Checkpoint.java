package com.example.checkpointstatuses.checkpointstatuses.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "checkpoints")
public class Checkpoint {
    @Id
    private String id;

    private String name;
    private String country;
    private Integer load;
    private Boolean active;

    public Checkpoint() {}

    public Checkpoint(String name, String country, Integer load, Boolean active) {
        this.name = name;
        this.country = country;
        this.load = load;
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id='%s', name='%s', country='%s', load='%s', active='%s']",
                id, name, country, load, active);
    }
}
