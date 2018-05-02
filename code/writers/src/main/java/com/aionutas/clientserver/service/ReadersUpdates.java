package com.aionutas.clientserver.service;



import com.aionutas.clientserver.model.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

@Configuration
public class ReadersUpdates implements Observer {



    public String updateString(Observable o, Object arg) {
         update(o, arg);
        Article article = (Article) arg;
         String newMessage = null;
         newMessage = "New article with title '" + article.getTitle() + "' added by " + article.getAuthor().getName();

       return newMessage;
    }

    public void update(Observable o, Object arg) {

    }
}
