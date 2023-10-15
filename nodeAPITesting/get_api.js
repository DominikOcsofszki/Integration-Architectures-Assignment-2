
require('dotenv').config();


const config = { headers: { 'Authorization': `Bearer ${process.env.ACCESS_TOKEN}`, 'Content-Typ': 'application/x-www-form-urlencoded', 'Accept': 'application/json', } };

