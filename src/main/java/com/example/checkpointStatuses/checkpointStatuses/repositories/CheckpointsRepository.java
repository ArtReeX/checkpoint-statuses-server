package com.example.checkpointStatuses.checkpointStatuses.repositories;

import com.example.checkpointStatuses.checkpointStatuses.models.Checkpoint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckpointsRepository extends MongoRepository<Checkpoint, String> {
}
