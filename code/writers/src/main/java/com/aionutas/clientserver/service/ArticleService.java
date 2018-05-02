package com.aionutas.clientserver.service;


import com.aionutas.clientserver.model.entity.Article;
import com.aionutas.clientserver.model.entity.Writer;
import com.aionutas.clientserver.model.repository.ArticleRepo;
import com.aionutas.clientserver.model.repository.WriterRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Observable;

@EnableMongoRepositories(basePackageClasses = ArticleRepo.class)
@Configuration
public class ArticleService extends Observable{

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    WriterRepo writerRepo;



    public Article addArticle(Article article) {
        Writer writer = writerRepo.findById(article.getAuthor().getId()).get();
        if (writer != null) {
            article.setAuthor(writer);
            setChanged();
            return articleRepo.save(article);
        } else {
            System.out.println("Could not find author");
        }
        return null;
    }

    public List<Article> findAllArticles() {
        return articleRepo.findAll();
    }

   public String seeUpdates(String string){
       return string;
   }


    public void deleteArticle(Long id) {
        Article removeArticle = articleRepo.findById(id).get();

        if(removeArticle.getId() != null) {
            articleRepo.delete(removeArticle);
        }
        else{
            System.out.println("Could not delete article!");
        }

    }
}
