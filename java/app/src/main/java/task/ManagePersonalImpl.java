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
import static java.lang.System.out;

public class ManagePersonalImpl implements ManagePersonal, ManagePersonalMissingCRUD {

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
//            System.out.println("document = " + document);//        db_task1.getCollection("sale")(document);
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
            out.println("document = " + document);
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
//            System.out.println("document = " + document);
//            System.out.println("document.toJson() = " + document.toJson());
            SalesMan salesMan;
            try {
                salesMan = gson.fromJson(document.toJson(), SalesMan.class); // deserializes json
            } catch (Exception e) {
                salesMan = null;
//                System.out.println("document = " + document);
//                System.out.println("document.toJson() = " + document.toJson());
//                System.out.println("e = " + e);
            }
//            System.out.println("read SalesMan sid:" + sid + ": " + salesMan.toString());
            return salesMan;
        }
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("SalesMen");

            FindIterable<Document> documents = salesmen.find(eq(key, attribute));
            List<SalesMan> listSalesMan = new ArrayList<>();
            Gson gson = new Gson(); //
            out.println("documents = " + documents);
            documents.forEach(System.out::println);
            for (Document document : documents) {
                out.println("document in for documents = " + document.toJson());
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
            MongoCollection<Document> evaluationRecordCollection = db_task1.getCollection("EvaluationRecord");
            Document document = evaluationRecordCollection.find(eq("salesManId", sid)).first(); //ToDo Only
            Gson gson = new Gson(); //
            out.println("document = " + document);
            EvaluationRecord evaluationRecord = gson.fromJson(document.toJson(), EvaluationRecord.class);
            return evaluationRecord;
        }
    }

    //--------------------Task 2--------------------
    @Override
    public void deleteSalesMan(int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> salesmen = db_task1.getCollection("SalesMen");
            String query = "{id: " + sid + "}";
            out.println(salesmen.find(eq("id", sid)).first());
            salesmen.deleteOne(eq("id", sid));
            out.println("del one");
            out.println(salesmen.find(eq("id", sid)).first());
            out.println("del one");
        }
    }


    @Override
    public void deleteEvaluationRecords(int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> evaluationRecordDB = db_task1.getCollection("EvaluationRecord");

            String query = "{id: " + sid + "}";
            out.println(evaluationRecordDB.find(eq("id", sid)).first());

            evaluationRecordDB.deleteOne(eq("id", sid));
        }
    }

    @Override
    public void updateSalesMan(SalesMan salesMan, int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> saleManCollection = db_task1.getCollection("SaleMan");
            this.deleteSalesMan(sid);
//            saleManCollection.deleteOne(eq("id", sid));
//            saleManCollection.insertOne(new Document("id", sid).append("firstname", salesMan.firstname).append("lastname", salesMan.lastname));
            this.createSalesMan(salesMan); //ToDo real update?
            out.println(saleManCollection.find(eq("id", sid)).first());
        }
    }

    @Override
    public void updateEvaluationRecord(EvaluationRecord evaluationRecord) {
        //ToDo
    }

    @Override
    public void createEvaluationRecord(EvaluationRecord evaluationRecord) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> evaluationRecordCollection = db_task1.getCollection("EvaluationRecord");
            Document document = new Document();//
//            document.append("socialPerfomanceRecord", evaluationRecord.socialPerfomanceRecord); //ToDo Add _id for socialPerfomanceRecord ?
//            document.append("orderEvaluation", evaluationRecord.orderEvaluation);               //ToDo Add _id for orderEvaluation ?
            document.append("salesManId", evaluationRecord.salesManId);
            document.append("totalBonus", evaluationRecord.totalBonus);
            document.append("yearOfOrder", evaluationRecord.yearOfOrder);
            document.append("evaluationRecordID", evaluationRecord.evaluationRecordID);


            evaluationRecordCollection.insertOne(document);
        }
    }

    @Override
    public void updateSocialPerfomanceRecord(int sid, SocialPerfomanceRecord updatedRecord) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> EvaluationRecordColleciton = db_task1.getCollection("EvaluationRecord");
            EvaluationRecordColleciton.deleteOne(eq("id", sid));
            EvaluationRecordColleciton.insertOne(new Document("id", sid).append("socialPerfomanceRecord", updatedRecord));
            out.println(EvaluationRecordColleciton.find(eq("id", sid)).first());
        }
    }

    @Override
    public void deleteSocialPerfomanceRecord(int sid) {
        try (MongoClient client = new MongoClient("localhost", 27017);) {
            MongoDatabase db_task1 = client.getDatabase("db_task1");
            MongoCollection<Document> saleManCollection = db_task1.getCollection("EvaluationRecord");this.deleteSalesMan(sid);
            saleManCollection.deleteOne(eq("id", sid));

        }
    }
}
