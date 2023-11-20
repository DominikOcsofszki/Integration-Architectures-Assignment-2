//SalesMen Proto
export function SalesMenProto(id, firstName, lastName, email, ) {
        this.id=id,
        this.firstName=firstName,
        this.lastName=lastName,
        this.email=email;
    };
    SalesMenProto.prototype.toString = function(){
        return`
        id:${this.id},
        firstName: ${this.firstName},
        lastName: ${this.lastName},
        email:${this.email}`;
    }
    console.log("Object 1")
const s = new SalesMenProto(1,"dominik","ocsofszki","mail");
console.log(s.toString());
console.log("------------------");

console.log("Object 2")
const sCreate = Object.create(SalesMenProto)
console.log(sCreate)
sCreate.firstName="Paul";
sCreate.lastName="Marx";
sCreate.id=2;
sCreate.whatEver = 5;
console.log(sCreate);
console.log(sCreate.prototype.toString());
sCreate.prototype.firstName="Paul";
sCreate.prototype.lastName="Marx";
sCreate.prototype.id=2;
console.log(sCreate.prototype.toString());

////////
// // Dot notation
// myCar.make = "Ford";
// myCar.model = "Mustang";
// myCar.year = 1969;

// // Bracket notation
// myCar["make"] = "Ford";
// myCar["model"] = "Mustang";
// myCar["year"] = 1969;