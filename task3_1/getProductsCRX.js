import axios from "axios";

const baseUrl = 'https://sepp-crm.inf.h-brs.de/opencrx-rest-CRX';
const credentials = {username: 'guest', password: 'guest',};
const config = {headers: {'Accept': 'application/json'},auth: credentials,};

const productUrl = `${baseUrl}/org.opencrx.kernel.product1/provider/CRX/segment/Standard/product/`;

const allProducts = await axios.get(productUrl, config);

console.log(allProducts);