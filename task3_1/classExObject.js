const Person  = {
        _firstName : firstName,
        _lastName : lastName,

        greet : function() {
            console.log('Hello!');
          },
    }

const person1 = new Person("Dominik", "Ocsofszki");
console.log(person1)
person1.greet();
// Person.prototype.toString = this.firstName + " " + this.lastName;
// console.log(person1)
// Person.prototype.firstName = () => {return this._firstName }
// Person.prototype.lastName = () => {return this._lastName }
// console.log(person1)
