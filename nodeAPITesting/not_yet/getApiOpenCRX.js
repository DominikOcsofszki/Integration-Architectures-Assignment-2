
require('dotenv').config();

function printAll(file) {
	console.log(file)

}
// openCRX


async function run()  {
	const axios = require('axios');

	const baseUrl = '${process.env.BASE_URL_CRX}';
	const credentials = {
		username: 'guest', 
		password: 'guest', 
	};

	const config = { headers: { 'Accept': 'application/json' }, auth: credentials, }; 
	const contacts = await axios.get(`${baseUrl}/org.opencrx.kernel.account1/provider/CRX/segment/Standard/account`, config);

	const accounts = contacts.data.objects;
	console.log(accounts[5].fullName)
	accounts.forEach(printAll())
	// for(let file in accounts) {
	//
	// console.log(file.fullName)
	// }
};


run();
