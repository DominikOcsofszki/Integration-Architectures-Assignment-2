package task;




import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    public static void main() {

        // Replace the placeholder with your MongoDB deployment's connection string
        // String uri = "localhost:1993";
        String uri = "mongodb://localhost:1993";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("db_task1");
            MongoCollection<Document> collection = database.getCollection("user");

            System.out.println(collection.find());
            Document doc = collection.find(eq("user", "Dominik")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}
