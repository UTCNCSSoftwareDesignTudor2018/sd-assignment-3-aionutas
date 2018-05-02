package com.aionutas.readers.service;


import com.aionutas.readers.model.entity.Article;
import com.aionutas.readers.model.entity.Reader;
import com.aionutas.readers.model.repository.ReaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = ReaderRepo.class)
@Configuration
public class ReaderService {

    @Autowired
    ReaderRepo readerRepo;


    public List<Article> findAllArticles() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Article>> articles =
                restTemplate.exchange("http://localhost:8088/articles/articles",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Article>>() {
                        });
        return articles.getBody();
    }

    public List<String> seeUpdates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> articles =
                restTemplate.exchange("http://localhost:8088/articles/seeUpdates",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
                        });
        return articles.getBody();
    }


    public Reader addReader(Reader reader) {
        return readerRepo.save(reader);
    }

    public Optional<Reader> getById(Long id) {
        return readerRepo.findById(id);
    }

    public void deleteReader(Long id) {
        Reader removeReader = readerRepo.findById(id).get();

        if (removeReader.getId() != null) {
            readerRepo.delete(removeReader);
        } else {
            System.out.println("Could not delete reader!");
        }

    }

    public List<Reader> findAllReaders() {
        return readerRepo.findAll();
    }

    public Reader updateReader(Reader reader) {
        return readerRepo.save(reader);
    }

}
