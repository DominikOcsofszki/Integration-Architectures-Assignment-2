package de.hbrs.erasmux;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
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
    public void createSalesMan(SalesMan salesMan) {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        salesmen.insertOne(objectToDocument(salesMan,SalesMan.class));
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        Document document = salesmen.find(eq("id", sid)).first();
        if(document == null) {
            return null;
        }
        return gson.fromJson(document.toJson(), SalesMan.class);
    }

    @Override
    public void updateSalesMan(int sid, SalesMan updatedSalesMan) {
        this.deleteSalesMan(sid);
        this.createSalesMan(updatedSalesMan);
    }

    @Override
    public void deleteSalesMan(int sid) {
        MongoCollection<Document> salesmen = client.getSalesManCollection();
        salesmen.deleteOne(eq("id", sid));
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
