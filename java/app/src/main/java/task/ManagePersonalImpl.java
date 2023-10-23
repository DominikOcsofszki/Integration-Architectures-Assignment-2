package task;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
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

//    DBSingleton dbSingleton = DBSingleton.getInstance();

    @Override
    public void createSalesMan(SalesMan record) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("SalesMen");
            Document document = new Document();//        document.append("firstname" , "Sascha");
            document.append("firstname", record.vorname);//        document.append("lastname" , "Alda");
            document.append("lastname", record.nachname);//        document.append("id" , 90133);
            document.append("id", record.id);
//            document.append("_id", record.id); //ToDo with this we can have only one ID per Person
            System.out.println("document = " + document);//        db_task1.getCollection("sale")(document);
            salesmen.insertOne(document);
        }
    }

    @Override
    public void addPerformanceReord(EvaluationRecord record, int sid) {

    }

    @Override
    public SalesMan readSalesMan(int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("SalesMen");
//            System.out.println("salesmen.find().first().toString() = " + salesmen.find().first().toString());

            return null;
        }
//    }public SalesMan readSalesMan(int sid) {
//        return dbSingleton.getDb_task1().getCollection("SalesMan").find().first().toString();
//    }
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
