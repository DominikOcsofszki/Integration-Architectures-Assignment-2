// require('dotenv').config();
//



async function getToken() { 
	require('dotenv').config();
	const axios = require('axios');
	const qs = require('querystring');
	const baseUrl = `${process.env.BASE_URL}`;
	let accessToken = null;
	const body = qs.stringify({ client_id: 'api_oauth_id', client_secret: 'oauth_secret', 
		grant_type: 'password', username: `${process.env.USER_WEBSITE}`, password: `${process.env.PASSWORD}` });
	const config = { headers: { 'Content-Type': 'application/x-www-form-urlencoded', 'Accept': 'application/json', } };
	const res = await axios.post(`${baseUrl}/oauth/issueToken`, body, config);
	if (res.data.error) { 
		throw Error(res.data.error);	
	}
	accessToken = res.data['access_token'];
	console.log(accessToken);
}


getToken();
