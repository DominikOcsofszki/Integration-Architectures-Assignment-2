package task;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class ManagePersonalImpl implements ManagePersonal {

//    private MongoClient client;
//    private MongoDatabase supermongo;
//    private MongoCollection<Document> salesmen;

//    client = new MongoClient("localhost", 27017);
//    // Get database 'highperformance' (creates one if not available)
//    supermongo = client.getDatabase("highperformance");
//    // Get Collection 'salesmen' (creates one if not available)
//    salesmen =


/*    private MongoCollection<Document> useDB(){
        MongoCollection<Document> salesmen;
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            salesmen = db_task1.getCollection("salesmen");
            return salesmen;
        }
    }*/
////////////////////////////////////////
//    private MongoCollection<Document> salesmen;

    DBSingleton dbSingleton = DBSingleton.getInstance();

    @Override
    public void createSalesMan(SalesMan record) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
        Document document = new Document();
//        document.append("firstname" , "Sascha");
        document.append("firstname" , record.vorname);
//        document.append("lastname" , "Alda");
        document.append("lastname" , record.nachname);
//        document.append("id" , 90133);
        document.append("id" , record.id);
        System.out.println("document = " + document);
//        db_task1.getCollection("sale")(document);
        dbSingleton.getDb_task1().getCollection("name").insertOne(document);
    }}

    @Override
    public void addPerformanceReord(EvaluationRecord record, int sid) {

    }

    @Override
    public SalesMan readSalesMan(int sid) {
        return dbSingleton.getDb_task1().getCollection("name").find().first();
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        return null;
    }

    @Override
    public EvaluationRecord readEvaluationRecords(int sid) {
        return null;
    }
}
