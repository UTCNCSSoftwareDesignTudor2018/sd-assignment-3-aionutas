package com.aionutas.clientserver.controller;

import com.aionutas.clientserver.model.entity.Article;
import com.aionutas.clientserver.model.entity.Writer;
import com.aionutas.clientserver.service.ArticleService;
import com.aionutas.clientserver.service.WritersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/writers")
public class WriterController {

    @Autowired
    WritersService writersService;

    @RequestMapping(value = "/findAuthor/{id}", method = RequestMethod.GET)
    public Optional<Writer> findWriterById(@PathVariable Long id) {
       return writersService.getById(id);
    }


    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public Writer addWriter(@RequestBody Writer writer) {
            if(!writersService.getById(writer.getId()).isPresent()){
            return writersService.addWriter(writer);}
            else return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWriter(@PathVariable(value = "id") Long id) {
        writersService.deleteWriter(id);
    }

    @RequestMapping(value = "/writers", method = RequestMethod.GET)
    public List<Writer> getAllWriters() {
        return writersService.findAllWriters();
    }

    @RequestMapping(value = "/updateWriterAccount", method = RequestMethod.PUT)
    public Writer updateWriter(@RequestBody Writer writer) {
        Writer existingWriter = writersService.getById(writer.getId()).get();
        if (existingWriter.getId() != null) {
            writer.setId(existingWriter.getId());
            return writersService.updateWriter(writer);
        }
        return null;
    }




}
