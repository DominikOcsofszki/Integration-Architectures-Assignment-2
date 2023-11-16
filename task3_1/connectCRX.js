
const axios = require('axios');
const baseUrl = 'https://sepp-crm.inf.h-brs.de/opencrx-rest-CRX';
const credentials = {username: 'guest', password: 'guest',};
const config = {
    headers: {'Accept': 'application/json'},
    auth: credentials,
};

async function getCustomer(accountNr) {
    // const contacts = await axios.get(`${baseUrl}/org.opencrx.kernel.account1/provider/CRX/segment/Standard/account/${accountNr}`, config);
    const contacts = await axios.get(`https://sepp-crm.inf.h-brs.de/opencrx-rest-CRX/org.opencrx.kernel.account1/provider/CRX/segment/Standard/account/9DXSJ5D62FBHLH2MA4T2TYJFL`, config);
    const customer = contacts.data.objects;
    console.log(customer)
}

// getAllCustomers();
getCustomer("9DXSJ5D62FBHLH2MA4T2TYJFL");