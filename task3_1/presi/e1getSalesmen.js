import {connectGetCollectionFromDB} from './e0mongoDB'
const express = require('express');
const app = express();

app.get( '/getsalesmen/:id' , (req , res) => {
    const id = req.params.id;
    console.log("The submitted ID is: " + id );
    getBonus(id).then( bonus => res.send( "{\"id\" : " + id + ", \"Bonus\": \""+bonus+" Euro\"}" ))});
app.listen(8080 , () => { console.log("Server läuft!");
});

async function getBonus(id){
    const salesmen = await connectGetCollectionFromDB("db_task1","salesmen",id);
    return salesmen.toString();
}
console.log("e.g.");
console.log("localhost:8080/getsalesmen/1");