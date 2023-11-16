const express = require('express');
const app = express();
app.get( '/bonus/:id' , (req , res) => {
    const id = req.params.id;
    console.log("The submitted ID is: " + id );
    res.send( "{\"id\" : " + id + ", \"Bonus\": \""+getBonus()+" Euro\"}" );
});
app.listen(8081 , () => { console.log("Server läuft!");
});
function getBonus(){
    return 10;
}