const express = require('express');
const getTokenHRM = require("./_getTokkenHRM")

const app = express();
app.get( '/tokken' , (req , res) => {
    res.send( "{\"tokken\" : " +getTokken()+" \"}" );
});
app.listen(8080 , () => { console.log("Server läuft!");
});
function getTokken(){
    tokken = getTokenHRM();
    console.log(tokken);
}