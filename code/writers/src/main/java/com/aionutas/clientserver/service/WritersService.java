package com.aionutas.clientserver.service;

import com.aionutas.clientserver.model.entity.Article;
import com.aionutas.clientserver.model.entity.Writer;
import com.aionutas.clientserver.model.repository.WriterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = WriterRepo.class)
@Configuration
public class WritersService {


    @Autowired
    WriterRepo writerRepo;

    public Writer addWriter(Writer writer) {
        return writerRepo.save(writer);
    }

    public Optional<Writer> getById(Long id) {
        return writerRepo.findById(id);
    }

    public void deleteWriter(Long id) {
        Writer removeWriter = writerRepo.findById(id).get();

        if(removeWriter.getId() != null) {
            writerRepo.delete(removeWriter);
        }
        else{
            System.out.println("Could not delete writer!");
        }

    }

    public List<Writer> findAllWriters() {
        return writerRepo.findAll();
    }

    public Writer updateWriter(Writer writer) {
        return writerRepo.save(writer);
    }
}
