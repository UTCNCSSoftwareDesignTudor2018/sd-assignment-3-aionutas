package com.aionutas.clientserver.controller;

import com.aionutas.clientserver.model.entity.Article;
import com.aionutas.clientserver.service.ArticleService;
import com.aionutas.clientserver.service.ReadersUpdates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")

public class ArticleController {


    @Autowired
    ArticleService articleService;
    List<Article> initialList = new ArrayList<>();

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public Article addArticle(@RequestBody Article article) {
        initialList = articleService.findAllArticles();
        Article art = articleService.addArticle(article);
        ReadersUpdates readers = new ReadersUpdates();
        articleService.deleteObserver(readers);
        articleService.addObserver(readers);
        articleService.notifyObservers(article);
        return art;

    }

    @RequestMapping(value = "/seeUpdates", method = RequestMethod.GET)
    public List<String> seeUpdates() {
        List<Article> articles = new ArrayList<>();
        articles.addAll(articleService.findAllArticles());
        List<String> updates = new ArrayList<>();
        List<String> noUpdates = new ArrayList<>();
        noUpdates.add("No new articles. Stay tuned!");
        ReadersUpdates readersUpdates = new ReadersUpdates();


        for (Article article : articleService.findAllArticles()) {
            if(!initialList.contains(article)) {
                updates.add(readersUpdates.updateString(articleService, article));
                initialList.add(article);
            }
        }
        if(!updates.isEmpty()) {
            return updates;
        }
        else
        {
            return noUpdates;
        }
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable(value = "id") Long id) {
        articleService.deleteArticle(id);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public List<Article> getAllArticles() {
        return articleService.findAllArticles();
    }



}
