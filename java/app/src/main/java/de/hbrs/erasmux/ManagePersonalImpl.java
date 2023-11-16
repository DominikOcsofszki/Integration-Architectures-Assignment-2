package de.hbrs.erasmux;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import de.hbrs.erasmux.model.BonusComputationSheet;
import de.hbrs.erasmux.model.SalesMan;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class ManagePersonalImpl implements ManagePersonal, ManageRecords {

    private ClientManager client = new ClientManager();
    private Gson gson = new Gson();
    //Salesman

    @Override
    public void createSalesMan(SalesMan salesMan){
        checkSalesman(salesMan);
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        salesmen.insertOne(objectToDocument(salesMan,SalesMan.class));
    }

    private void checkSalesman(SalesMan salesMan){
        if (salesMan.id == null){
            throw new IllegalArgumentException("Salesman needs id");
        }
        if (isIdOccupied(salesMan.id)){
            throw new IllegalArgumentException("Salesman with this id exists already");
        }
        if (salesMan.firstname == null){
            throw new IllegalArgumentException("Salesman needs a firstname");
        }
        if (salesMan.lastname == null){
            throw new IllegalArgumentException("Salesman needs a lastname");
        }
    }

    private boolean isIdOccupied(int sid){
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        Document document = salesmen.find(eq("id", sid)).first();
        return document != null;
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        Document document = salesmen.find(eq("id", sid)).first();
        if(document == null) {
            throw new IllegalArgumentException("No salesman with this id");
        }
        return gson.fromJson(document.toJson(), SalesMan.class);
    }

    @Override
    public void updateSalesMan(SalesMan updatedSalesMan) {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        UpdateResult result = salesmen.replaceOne((eq("id", updatedSalesMan.id)), objectToDocument(updatedSalesMan, SalesMan.class));
        if (result.getModifiedCount() == 0){
            throw new IllegalArgumentException("No salesman with this id");
        }
    }

    @Override
    public void deleteSalesMan(int sid) {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        DeleteResult result = salesmen.deleteOne(eq("id", sid));
        if (result.getDeletedCount() == 0){
            throw new IllegalArgumentException("Salesman with this id does not exist");
        }
    }

    //Shows all SalesMan with a certain attribute
    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        FindIterable<Document> documents = salesmen.find(eq(key, attribute));
        List<SalesMan> listSalesMan = new ArrayList<>();
        for (Document document : documents) {
            SalesMan salesMan = gson.fromJson(document.toJson(), SalesMan.class);
            listSalesMan.add(salesMan);
        }
        return listSalesMan;
    }

    public void _dropAllSalesMan() {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        salesmen.drop();
    }

    //Bonus Computation Sheet

    //Bonus Computation Sheet

    public void createBonusComputationSheet(BonusComputationSheet sheet) {
        MongoCollection<Document> sheetCollection = client.getBonusComputationSheetCollection();
        Document document = objectToDocument(sheet,BonusComputationSheet.class);
        sheetCollection.insertOne(document);
    }

    public BonusComputationSheet readBonusComputationSheet(int salesManId, int year) {
        MongoCollection<Document> sheetCollection = client.getBonusComputationSheetCollection();
        Document document = sheetCollection.find(and(eq("salesManId", salesManId),eq("yearOfOrder", year))).first();
        if(document == null) {
            return null;
        }
        return gson.fromJson(gson.toJson(document, Document.class),BonusComputationSheet.class);
    }

    public void updateBonusComputationSheet(int sid, int year, BonusComputationSheet sheet) {
        deleteBonusComputationSheet(sid,year);
        createBonusComputationSheet(sheet);
    }

    public void deleteBonusComputationSheet( int salesManId, int year) {
        MongoCollection<Document> sheetCollection = client.getBonusComputationSheetCollection();
        sheetCollection.deleteOne(and(eq("salesManId", salesManId),eq("yearOfOrder", year)));
    }

    public void _dropAllBonusComputationSheets() {
        MongoCollection<Document> sheets = client.getBonusComputationSheetCollection();
        sheets.drop();
    }

    //Helper

    private Document objectToDocument(Object o, Class c) {
        String temp = gson.toJson(o, c);
        return new Document(gson.fromJson(temp, new TypeToken<HashMap<String, Object>>() {}.getType()));
    }


}
