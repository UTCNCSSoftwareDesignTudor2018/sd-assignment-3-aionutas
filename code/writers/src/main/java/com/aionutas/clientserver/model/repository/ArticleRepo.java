package com.aionutas.clientserver.model.repository;

import com.aionutas.clientserver.model.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepo extends MongoRepository<Article, Long> {

}
