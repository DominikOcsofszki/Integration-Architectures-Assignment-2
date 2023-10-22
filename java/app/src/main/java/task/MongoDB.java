//package task;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
////private MongoClient client;
////private MongoDatabase supermongo;
////private MongoCollection<Document> salesmen;
//public class MongoDB {
//    public static void main() {
//
//        // Replace the placeholder with your MongoDB deployment's connection string
//        // String uri = "localhost:1993";
//        String mongoDB = "mongodb://localhost:27017";
//        MongoClient client = new MongoClient("localhost", 27017);
////        void setUp() {
////            // Setting up the connection to a local MongoDB with standard port 27017
////            // must be started within a terminal with command 'mongod'.
////            client = new MongoClient("localhost", 27017);
////
////            // Get database 'highperformance' (creates one if not available)
////            supermongo = client.getDatabase("highperformance");
////
////            // Get Collection 'salesmen' (creates one if not available)
////            salesmen = supermongo.getCollection("salesmen");
////        }
//
//        try (MongoClient mongoClient = MongoClients.create(mongoDB)) {
//
//
//            MongoDatabase database = mongoClient.getDatabase("db_task1");
////            System.out.println(database.getName());
//            System.out.println(database.getCollection("user").countDocuments());
//            FindIterable<Document> entries = database.getCollection("user").find();
//            for (Document entry : entries) {
//                System.out.println(entry.toJson());
//            }
//            entries.forEach(System.out::println);
////             MongoCollection<Document> collection = database.getCollection("user");
//
////            mongoClient.listDatabaseNames().forEach(System.out::println);
////            MongoCollection<Document> salesmen = database.getCollection("user");
//
////            Document searchQuery = new Document();
////            searchQuery.put("name", "John");
////            FindIterable<Document> cursor = collection.find(searchQuery);
//
//            // System.out.println(collection.find());
//            // Document doc = collection.find(eq("user", "Dominik")).first();
//            // if (doc != null) {
//            //     System.out.println(doc.toJson());
//            // } else {
//            //     System.out.println("No matching documents found.");
//            // }
//////            add customer
////            MongoCollection<Document> collection = database.getCollection("customers");
////            Document document = new Document();
////            document.put("name", "Shubham");
////            document.put("company", "Baeldung");
////            collection.insertOne(document);
//        }
//    }
//}
