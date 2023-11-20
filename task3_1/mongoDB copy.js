import {MongoClient} from 'mongodb'
import { config } from 'dotenv';
import { SalesMen } from './SalesMen';
config();

async function connectDBClient() {
    const uri = `${process.env.DB_URL}`;
    const client = new MongoClient(uri);
    try {
        await client.connect();
        return client;
    } catch (e) {console.error(e);}
    // finally {await client.close();}
    }
async function getDBFromClient(client,dbName) {
            const db = await client.db(`${dbName}`);
        // const db = await client.db('db_task1');
            return db;
}
async function getCollectionFromDB(db,collectionName) {
        const collection = await db.collection(`${collectionName}`);
        return collection;
        // console.log(`added document: ${documentSalesmen}`)
}

// const clientDB = await connectDBClient();
// const db = await getDBFromClient(clientDB, "db_task1");
// const collectionSalesMen = await getCollectionFromDB(db,"salesmen");

export async function connectGetCollectionFromDB(dbName, collectionName,id) {
    const clientDB = await connectDBClient();
    const db = await getDBFromClient(clientDB, "db_task1");
    const collection = await getCollectionFromDB(db,"salesmen");
    return [clientDB, collection];
}
// const arr  = await connectGetCollectionFromDB("123","asd");
// // clientDB.close();
// // collection.close();

// // console.log(`added document: ${documentSalesmen}`)
// const sm = new SalesMen(1,"dominik","ocsofszki","mail");
// await arr[1].insertOne(sm);
// arr[0].close();
