package com.aionutas.readers.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Article {
    @Id
    private Long id;

    private String title;
    private String articleAbstract;
    private Writer author;
    private String body;

    public Article(Long id, String title, String articleAbstract, Writer author, String body) {
        this.id = id;
        this.title = title;
        this.articleAbstract = articleAbstract;
        this.author = author;
        this.body = body;
    }

    public Article(String title, String articleAbstract, Writer author, String body) {
        this.title = title;
        this.articleAbstract = articleAbstract;
        this.author = author;
        this.body = body;
    }

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public Writer getAuthor() {
        return author;
    }

    public void setAuthor(Writer author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != null ? !id.equals(article.id) : article.id != null) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (articleAbstract != null ? !articleAbstract.equals(article.articleAbstract) : article.articleAbstract != null)
            return false;
        if (author != null ? !author.equals(article.author) : article.author != null) return false;
        return body != null ? body.equals(article.body) : article.body == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (articleAbstract != null ? articleAbstract.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", author='" + author + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
