export class Person {
    constructor (firstName, lastName) {
        this._firstName = firstName;
        this._lastName = lastName;
    }
    set firstName (firstName) {
        this._firstName=firstName;
    }
    set lastName (lastName) {
        this._lastName=lastName;
    }
    get firstName() {
        return this._firstName;
    }
    get lastName() {
        return this._lastName;
    }
}
const person1 = new Person("Dominik", "Ocsofszki");
console.log("classExObject: "+person1)
