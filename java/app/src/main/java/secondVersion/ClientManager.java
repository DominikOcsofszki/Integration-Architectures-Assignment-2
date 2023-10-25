package secondVersion;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ClientManager {

    //@Todo Exception Handling

    private MongoClient client;
    private final int PORT = 27017;

    public ClientManager() {
        this.client = new MongoClient("localhost", PORT);
    }

    public MongoCollection<Document> getSalesManCollection() {
        return this.client.getDatabase("db_task1").getCollection("SalesMen");
    }

    public MongoCollection<Document> getBonusComputationSheetCollection() {
        return this.client.getDatabase("db_task1").getCollection("BonusComputationSheet");
    }

}
