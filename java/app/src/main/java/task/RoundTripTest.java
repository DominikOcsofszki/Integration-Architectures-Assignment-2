package task;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
//import de.hbrs.ia.model.SalesMan;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

class RoundTripTest {

    private MongoClient client;
    private MongoDatabase db_task1;
    private MongoCollection<Document> salesmen;
    MongoCollection<Document> evaluationRecordDB;
    MongoCollection<Document> salesmenDB;
    ManagePersonalImpl managePersonal;
    SalesMan salesMan;

    /**
     * Attention: You might update the version of the Driver
     * for newer version of MongoDB!
     * This tests run with MongoDB 4.2.17 Community
     */
    @BeforeEach
    void setUp() {
////        try (MongoClient client = new MongoClient("localhost", 27017);) {
//        client = new MongoClient("localhost", 27017);
//        db_task1 = client.getDatabase("db_task1");
//        evaluationRecordDB = db_task1.getCollection("EvaluationRecord");
//        salesmenDB = db_task1.getCollection("SalesMen");
//        managePersonal = new ManagePersonalImpl();
//        salesMan = new SalesMan("Dominik", "Ocsofszki", 90133);
//        final SocialAttribute socialAttribute = new SocialAttribute("better next time", 5, 4);
//        final SocialPerfomanceRecord socialPerfomanceRecord = new SocialPerfomanceRecord(socialAttribute, 2_000);
//        final Order order = new Order("HooverGo", "TKMax", "A", 200, 20, "last year we had 10 more sold");
//        final Order order2 = new Order("HooverGo", "TKMax", "A", 200, 20, "last year we had 10 more sold");
//        ArrayList<Order> orders = new ArrayList();
//        orders.add(order);
//        orders.add(order);
//        final OrderEvaluation orderEvaluation = new OrderEvaluation(orders, 1_000);
//        final EvaluationRecord evaluationRecord = new EvaluationRecord(socialPerfomanceRecord, orderEvaluation, 1, 3_000, 2023);
//        managePersonal._dropAllSalesMan();
    }

    @Test
    void roundTripTest() {
        ManagePersonalImpl managePersonal = new ManagePersonalImpl();
        managePersonal._dropAllSalesMan();

        SalesMan salesMan = new SalesMan("Dominik", "Ocsofszki", 90133);
        //---------------

        /*final SocialAttribute socialAttribute = new SocialAttribute("Leadership Competence", 4, 3, 20, "whats wrong?");
        final SocialAttribute socialAttribute2 = new SocialAttribute("Openness to Employee", 4, 3, 20, "whats wrong?");
        final ArrayList<SocialAttribute> socialAttributes = new ArrayList();
        socialAttributes.add(socialAttribute);
        socialAttributes.add(socialAttribute2);
        final SocialPerfomanceRecord socialPerfomanceRecord = new SocialPerfomanceRecord(socialAttributes, 2_000);
        final Order order1 = new Order("HooverGo", "Telekom AG", "A", 700, 20, "YES!");
        final Order order2 = new Order("HooverGo", "Mayer", "B", 500, 10, "YES");
        ArrayList<Order> orders = new ArrayList();
        orders.add(order1);
        orders.add(order2);
        final OrderEvaluation orderEvaluation = new OrderEvaluation(orders, 1_000);
//        final EvaluationRecord evaluationRecord = new EvaluationRecord(socialPerfomanceRecord, orderEvaluation, 1, 3_000, 2023);*/
        //------------
        SalesMan salesMan1 = managePersonal.readSalesMan(90133);
        //check before
        assertNull(salesMan1);
        managePersonal.createSalesMan(salesMan);
        //create
         salesMan1 = managePersonal.readSalesMan(90133);
        //Check if inserted
         assertEquals(90133, salesMan1.id);
        //delete
        managePersonal.deleteSalesMan(90133);
        salesMan1 = managePersonal.readSalesMan(90133);
        //Check if deleted
        assertNull(salesMan1);
        managePersonal._dropAllSalesMan();

    }

//    @Test
//    void insertSalesManMoreObjectOriented() {
//        // CREATE (Storing) the salesman business object
//        // Using setter instead
//        SalesMan salesMan = new SalesMan("Leslie", "Malton", 90444);
//
//        // ... now storing the object
//        salesmen.insertOne(salesMan.toDocument());
//
//        // READ (Finding) the stored Documnent
//        // Mapping Document to business object would be fine...
//        Document newDocument = this.salesmen.find().first();
//        System.out.println("Printing the object (JSON): " + newDocument);
//
//        // Assertion
//        Integer id = (Integer) newDocument.get("id");
//        assertEquals(90444, id);
//
//        // Deletion
//        salesmen.drop();
//    }
}
