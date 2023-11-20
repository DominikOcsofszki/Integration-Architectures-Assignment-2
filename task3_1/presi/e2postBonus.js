var express = require('express');
var bodyParser = require('body-parser');
var app = express();
app.use( bodyParser.json() );

app.post('/setBonus', function(req, res) {
    console.log('receiving data ...');
    const id = req.body.id;
    const bonus = req.body.bonus;
    console.log(`id is: ${id}, bonus is: ${bonus}`);
    res.send(req.body);
});

app.listen(8080);
console.log("listen:");
console.log("localhost:8080/setBonus");