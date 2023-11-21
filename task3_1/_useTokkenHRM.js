import getTokenHRM from "./_getTokkenHRM";
import axios from "axios";

console.log("1");

const tokken =  await getTokenHRM();
const config = {
    headers: { Authorization: `Bearer ${tokken}` }
};

const listofEmployee = await axios.get("https://sepp-hrm.inf.h-brs.de/symfony/web/index.php/api/v1/employee/search", config);

console.log(listofEmployee);