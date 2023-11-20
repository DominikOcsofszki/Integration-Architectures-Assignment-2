// Using a constructor function

function Pizza(namePizza){
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked (:constructor function)`);
      };
}

//Extending Objects with prototype
Pizza.prototype.burned = function() {
  console.log(`${this.namePizza} Pizza is burned (:constructor function)`);
}

const pizza = new Pizza("Salami");
pizza.baked();
pizza.burned();

console.log(Pizza)