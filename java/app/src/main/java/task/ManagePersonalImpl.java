package task;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ManagePersonalImpl implements ManagePersonal {

    @Override
    public void createSalesMan(SalesMan record) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("SalesMen");
            Document document = new Document();//        document.append("firstname" , "Sascha");
            document.append("firstname", record.firstname);//        document.append("lastname" , "Alda");
            document.append("lastname", record.lastname);//        document.append("id" , 90133);
            document.append("id", record.id);
            document.append("_id", record.id); //ToDo with this we can have only one ID per Person
            System.out.println("document = " + document);//        db_task1.getCollection("sale")(document);
            salesmen.insertOne(document);

        }
    }

    public void _dropAllSalesMan() {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("SalesMen");
            salesmen.drop();
        }
    }

    @Override
    public void addPerformanceRecord(EvaluationRecord record, int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("PerformanceRecord");
            Document document = new Document();
            Gson gson = new Gson(); //
            document.append("sid", sid);
            document.append("socialPerfomanceRecord", gson.toJson(record.socialPerfomanceRecord)); //ToDo PerformanceRecord or Record?
            System.out.println("document = " + document);
            salesmen.insertOne(document);

        }
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("SalesMen");
            String query = "{id: " + sid + "}";
            Document document = salesmen.find(eq("id", sid)).first(); //ToDo Only first since we have only one ID per Person?
//            Document document = salesmen.find().first();
            Gson gson = new Gson(); //
            System.out.println("document = " + document);
            System.out.println("document.toJson() = " + document.toJson());
            SalesMan salesMan = gson.fromJson(document.toJson(), SalesMan.class); // deserializes json
            System.out.println("read SalesMan sid:" + sid + ": " + salesMan.toString());
            return salesMan;
        }
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("EvaluationRecord");
            FindIterable<Document> documents = salesmen.find(eq(key, attribute));
            List<SalesMan> listSalesMan = new ArrayList<>();
            Gson gson = new Gson(); //
            System.out.println("document = " + documents);
            for (Document document : documents) {
                System.out.println("document = " + document);
                SalesMan salesMan = gson.fromJson(document.toJson(), SalesMan.class);
                listSalesMan.add(salesMan);
            }
            return listSalesMan;
        }
    }


    @Override
    public EvaluationRecord readEvaluationRecords(int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("EvaluationRecord");
            Document document = salesmen.find(eq("id", sid)).first(); //ToDo Only
            Gson gson = new Gson(); //
            System.out.println("document = " + document);
            EvaluationRecord evaluationRecord = gson.fromJson(document.toJson(), EvaluationRecord.class);
            return evaluationRecord;
        }
    }
}
