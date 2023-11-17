const Person  = {
        _firstName : firstName,
        _lastName : lastName,

        greet : function() {
            console.log('Hello!');
          },
    }

const person1 = new Person("Dominik", "Ocsofszki");
console.log("classExObject: "+person1)
person1.greet();