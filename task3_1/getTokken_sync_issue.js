const express = require('express');
const getTokkenHRM = require("./_getTokkenHRM")

const app = express();

app.get( '/tokken' , (req , res) => {
    res.send( "{\"tokken\" : " +getTokkenHRM()+" \"}" );
});

app.listen(8080 , () => { console.log("Server läuft!");
});