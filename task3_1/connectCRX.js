
import axios from "axios";
// const axios = require('axios');
const baseUrl = 'https://sepp-crm.inf.h-brs.de/opencrx-rest-CRX';
const credentials = {username: 'guest', password: 'guest',};
const config = {headers: {'Accept': 'application/json'},auth: credentials,};

async function getCustomer(accountNr) {
    // const regAccountNr =  await axios.get(`${baseUrl}/org.opencrx.kernel.account1/provider/CRX/segment/Standard/account/${accountNr}`, config);
    const regAccountNr =  await getAllAccounts();
}
async function getAllAccounts() {
    const regAccountNr =  await axios.get(`${baseUrl}/org.opencrx.kernel.account1/provider/CRX/segment/Standard/account/`, config);
    return regAccountNr;
}

// getAllCustomers();
getCustomer("9DXSJ5D62FBHLH2MA4T2TYJFL");