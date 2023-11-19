//SalesMen class

class SalesMen {
    constructor(id, firstName, lastName, email, ){
        this.id=id,
        this.firstName=firstName,
        this.lastName=lastName,
        this.email=email;
    }
    toString(){
        return`
        id:${this.id},
        firstName: ${this.firstName},
        lastName: ${this.lastName},
        email:${this.email}`;
    }
}
// SalesMen.prototype.toString = function() {
//     console.log(`
//     id:${this.id},
//     firstName: ${this.firstName},
//     lastName: ${this.lastName},
//     email:${this.email}`)
// }
const s = new SalesMen(1,"dominik","ocsofszki","mail");
console.log(s.toString());