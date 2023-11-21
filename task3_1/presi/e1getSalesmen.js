import {connectGetCollectionFromDB} from './e0mongoDB'
const express = require('express');
const app = express();

app.get( '/getsalesmen/:id' , (req , res) => {
    const id = req.params.id;
    console.log("The submitted ID is: " + id );
    getSalesmen(id).then(
        salesmen => res.send( "{\"id\" : " + id + ", \"Salesmen\": \""+salesmen+"\"}" ))
    });
app.listen(8080 , () => { console.log("Server läuft!");
});

async function getSalesmen(id){
    const salesmen = "id:1, firstName: Telekom, lastName: asd, email:do@mail.com";
    // const salesmen = await connectGetCollectionFromDB("db_task1","salesmen",id);
    return salesmen.toString();
}
console.log("e.g.");
console.log("localhost:8080/getsalesmen/1");