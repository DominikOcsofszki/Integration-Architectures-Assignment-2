//SalesMen class
export class SalesMen {
    constructor(id, firstName, lastName, email, ){
        this._id=id,
        this.firstName=firstName,
        this.lastName=lastName,
        this.email=email;
    }
    toString(){
        return`
        id:${this._id},
        firstName: ${this.firstName},
        lastName: ${this.lastName},
        email:${this.email}`;
    }
    someMethhode() {
        console.log("this is a class-method");
    }
}
const s = new SalesMen(1,"dominik","ocsofszki","mail");
// console.log(s.toString());
// s.someMethhode();