const express = require('express');
const getTokenHRM = require("./_getTokkenHRM")
const app = express();

app.get( '/tokken' , async (req , res) => {
    tokken = await getTokenHRM()
    .then(tokken => res.send( "{\"tokken\" : " +tokken+" \"}" ));
});

app.listen(8080 , () => { console.log("Server läuft!");
});
