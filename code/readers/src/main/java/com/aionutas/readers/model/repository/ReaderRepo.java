package com.aionutas.readers.model.repository;


import com.aionutas.readers.model.entity.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepo extends MongoRepository<Reader, Long> {
}
