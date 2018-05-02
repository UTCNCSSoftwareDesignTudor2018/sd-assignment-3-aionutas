package com.aionutas.clientserver;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.rmi.UnknownHostException;

public class MongoUtils {
    private static final String DATABASE_NAME="writers";
    private static final String COLLECTION_NAME="writer";
    private static MongoClient serverConnection = null;

    //TODO Thread Safety
    public static DBCollection getCollection() {
        if(serverConnection==null){
            serverConnection = new MongoClient("localhost",27017);
        }
        DB db = serverConnection.getDB(DATABASE_NAME);
        return db.getCollection(COLLECTION_NAME);
    }
}
