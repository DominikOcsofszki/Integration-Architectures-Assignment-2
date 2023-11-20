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

const pizza = new Pizza("Salami");
// const pizza2 = new Pizza("Margherita");
pizza.baked();
pizza.burned();
// pizza2.baked();