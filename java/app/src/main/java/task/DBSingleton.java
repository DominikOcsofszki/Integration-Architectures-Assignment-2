package task;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//
//public class db_singleton {
//
////    private static db_singleton instance = null;
//    private static MongoCollection<Document> salesmen;
//    private MongoCollection<Document> useDB(){
//        MongoCollection<Document> salesmen;
//        try (MongoClient client = new MongoClient("localhost", 27017);) {
//            MongoDatabase db_task1 = client.getDatabase("db_task1");
//            salesmen = db_task1.getCollection("salesmen");
//            return salesmen;
//        }
//    }
//    public static db_singleton getInstance() {
//        return new db_singleton();
//    }
//}

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public final class DBSingleton {
    private static MongoCollection<Document> salesmen;
    private static MongoCollection<Document> evaluationRecord;

    public MongoCollection<Document> getSalesmen() {
        return salesmen;
    }

    public MongoCollection<Document> getEvaluationRecord() {
        return evaluationRecord;
    }

    private MongoCollection<Document> dbSalesmen() {
        return dbReturnCollection("salesmen");
    }
    private MongoCollection<Document> dbEvaluationRecord() {
        return dbReturnCollection("EvaluationRecord");
    }
    private MongoCollection<Document> dbReturnCollection(String collectionName) {
        MongoCollection<Document> collection;
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            collection = db_task1.getCollection(collectionName);
            return collection;
        }
    }

    private static DBSingleton INSTANCE;
    private DBSingleton() {
        salesmen = dbSalesmen();
        evaluationRecord = dbEvaluationRecord();
    }

    public static DBSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBSingleton();
        }
        return INSTANCE;
    }
}