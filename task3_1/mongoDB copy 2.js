import {MongoClient} from 'mongodb'
import { config } from 'dotenv';
import { SalesMen } from './SalesMen';
config();

export async function connectGetCollectionFromDB(dbName, collectionName,id) {
    const uri = `${process.env.DB_URL}`;
    const client = new MongoClient(uri);
    try {
        await client.connect();
        const db = await client.db(`${dbName}`);
        const collection = await db.collection(`${collectionName}`);
        // const salesmen = new SalesMen (collection.find(id));
        const salesmenFromCollection = await collection.find(`id: ${id}`).json();
        const salesmen = new SalesMen(salesmenFromCollection);
        // console.log(salesmen);
        // console.log(salesmenFromCollection.);


        // console.log(salesmen);
        // console.log(salesmenFromCollection);


    } catch (e) {console.error(e);}
    // finally {await client.close();}
    }


// export async function connectGetCollectionFromDB2(dbName, collectionName,id) {
//     const clientDB = await connectDBClient();
//     const db = await getDBFromClient(clientDB, "db_task1");
//     const collection = await getCollectionFromDB(db,"salesmen");
//     return [clientDB, collection];
// }
// const arr  = await connectGetCollectionFromDB("123","asd");
// // clientDB.close();
// // collection.close();

// // console.log(`added document: ${documentSalesmen}`)
// const sm = new SalesMen(1,"dominik","ocsofszki","mail");
// await arr[1].insertOne(sm);
// arr[0].close();
