package com.aionutas.readers.controller;


import com.aionutas.readers.model.entity.Article;
import com.aionutas.readers.model.entity.Reader;
import com.aionutas.readers.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    ReaderService readerService;
    @RequestMapping(value = "/readArticles", method = RequestMethod.GET)
    public List<Article> getAllArticles() {
        return readerService.findAllArticles();
    }

    @RequestMapping(value = "/seeUpdates", method = RequestMethod.GET)
    public List<String> seeUpdates() {
        return readerService.seeUpdates();
    }

    @RequestMapping(value = "/findReader/{id}", method = RequestMethod.GET)
    public Optional<Reader> findWriterById(@PathVariable Long id) {
        return readerService.getById(id);
    }


    @RequestMapping(value = "/addReader", method = RequestMethod.POST)
    public Reader addReader(@RequestBody Reader reader) {
        if(!readerService.getById(reader.getId()).isPresent()){
            return readerService.addReader(reader);}
        else return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteReader(@PathVariable(value = "id") Long id) {
        readerService.deleteReader(id);
    }

    @RequestMapping(value = "/readers", method = RequestMethod.GET)
    public List<Reader> getAllReaders() {
        return readerService.findAllReaders();
    }

    @RequestMapping(value = "/updateWriterAccount", method = RequestMethod.PUT)
    public Reader updateReader(@RequestBody Reader reader) {
        Reader existingReader = readerService.getById(reader.getId()).get();
        if (existingReader.getId() != null) {
            reader.setId(existingReader.getId());
            return readerService.updateReader(reader);
        }
        return null;
    }

}
