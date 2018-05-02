package com.aionutas.readers.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongodb.DBCursor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Writer {
    @Id
    private Long id;
    private String name;
    private String email;
    //private List<Article> articles;

    public Writer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        //this.articles = articles;
    }

    public Writer(String name, String email) {
        this.name = name;
        this.email = email;
       // this.articles = articles;
    }

    public Writer(){}

    public Writer(DBCursor resultSubset) {
    }

//    public List<Article> getArticles() {
//        return articles;
//    }
//
//    public void setArticles(List<Article> articles) {
//        this.articles = articles;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Writer writer = (Writer) o;

        if (id != null ? !id.equals(writer.id) : writer.id != null) return false;
        if (name != null ? !name.equals(writer.name) : writer.name != null) return false;
        return email != null ? email.equals(writer.email) : writer.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
