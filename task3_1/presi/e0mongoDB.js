import {MongoClient} from 'mongodb'
import { config } from 'dotenv';
import { SalesMen } from './e0SalesMen';
// require('./SalesMen');
config();

export async function connectGetCollectionFromDB(dbName, collectionName,id) {
    console.log("inside connectGetCollectionFromDB");
    const uri = `${process.env.DB_URL}`;
    const client = new MongoClient(uri);
    const querry = ` "_id" : ${id} `;

    try {
        await client.connect();
        const db =  await client.db(`${dbName}`);
        const collection =  await db.collection(`${collectionName}`);
        // const salesmenFromCollection =  await collection.find({querry});
        const salesmenFromCollection =  await collection.find({});
        const arrSalesmen =  await salesmenFromCollection.toArray();
        // console.log(arrSalesmen[0]);
        const salesmen = new SalesMen(arrSalesmen[id]._id,arrSalesmen[id].firstName, arrSalesmen[id].lastName, arrSalesmen[id].email);
        console.log(salesmen);
        console.log("inside connectGetCollectionFromDB");
        return salesmen;
        // return arr;
    } catch (e) {console.error(e);}
    finally {await client.close();}
    }


// connectGetCollectionFromDB("db_task1","salesmen",0);