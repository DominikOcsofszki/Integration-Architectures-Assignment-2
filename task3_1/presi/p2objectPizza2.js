// Using a constructor function

function Pizza(namePizza){
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked (:constructor function)`);
      };
}

const pizza = new Pizza("Salami");
pizza.baked();