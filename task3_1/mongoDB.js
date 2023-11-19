import {MongoClient} from 'mongodb'
import { config } from 'dotenv';
// require('dotenv').config();
config();

async function listDatabases(client){
    const databasesList = await client.db().admin().listDatabases();
    console.log("Databases:");
    databasesList.databases.forEach(db => console.log(` - ${db.name}`));
};

async function connectDB() {
    const uri = `${process.env.DB_URL}`;
    const client = new MongoClient(uri);
    try {
        await client.connect();
        const db = client.db('db_task1');
        const collection = db.collection('salesmen');

        const documentSalesmen = {
            firstName: "roblox",
            lastName:"asd",
            email:"do@mail.com"
        }
        await collection.insertOne(documentSalesmen);
        console.log(`added document: ${documentSalesmen}`)
    } catch (e) {console.error(e);}finally {await client.close();}
    }

connectDB().catch(console.error);
