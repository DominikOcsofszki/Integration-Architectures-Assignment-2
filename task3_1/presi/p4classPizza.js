// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
      };
    }
}

//Extending Objects with prototype
Pizza.prototype.burned = function() {
  console.log(`${this.namePizza} Pizza is burned [prototype added function]`);
}
Pizza.prototype.addedVar = "someString, added by [prototype added var]"


const pizza = new Pizza("Salami");
pizza.baked();
pizza.burned();
console.log(pizza.addedVar);