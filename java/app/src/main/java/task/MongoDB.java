package task;




import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoDB {
    public static void main() {

        // Replace the placeholder with your MongoDB deployment's connection string
        // String uri = "localhost:1993";
        String mongoDB = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(mongoDB)) {


            MongoDatabase database = mongoClient.getDatabase("db_task1");
//            System.out.println(database.getName());
            System.out.println(database.getCollection("user").find().first().toJson());
//             MongoCollection<Document> collection = database.getCollection("user");

//            mongoClient.listDatabaseNames().forEach(System.out::println);
//            MongoCollection<Document> salesmen = database.getCollection("user");

//            Document searchQuery = new Document();
//            searchQuery.put("name", "John");
//            FindIterable<Document> cursor = collection.find(searchQuery);

            // System.out.println(collection.find());
            // Document doc = collection.find(eq("user", "Dominik")).first();
            // if (doc != null) {
            //     System.out.println(doc.toJson());
            // } else {
            //     System.out.println("No matching documents found.");
            // }
////            add customer
//            MongoCollection<Document> collection = database.getCollection("customers");
//            Document document = new Document();
//            document.put("name", "Shubham");
//            document.put("company", "Baeldung");
//            collection.insertOne(document);
        }
    }
}
