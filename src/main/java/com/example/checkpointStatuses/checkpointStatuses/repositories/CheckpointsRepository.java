package com.example.checkpointstatuses.checkpointstatuses.repositories;

import com.example.checkpointstatuses.checkpointstatuses.models.Checkpoint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckpointsRepository extends MongoRepository<Checkpoint, String> {
}
