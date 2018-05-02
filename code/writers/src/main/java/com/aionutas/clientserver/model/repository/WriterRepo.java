package com.aionutas.clientserver.model.repository;

import com.aionutas.clientserver.model.entity.Writer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WriterRepo extends MongoRepository <Writer, Long> {
}
